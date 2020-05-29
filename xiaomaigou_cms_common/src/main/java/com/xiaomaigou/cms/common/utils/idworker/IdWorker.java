package com.xiaomaigou.cms.common.utils.idworker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>名称：IdWorker</p>
 * <p>描述：分布式自增长ID</p>
 * <pre>
 *     分布式ID生成解决方案：
 *     1.UUID（不使用理由：[1]太长，[2]无法排序）
 *     2.Redis产生自增序号（主键的生成需要访问Redis，对Redis有依赖）
 *     3.Oracle数据库对象-序列（与表无关），只有数据库用Oracle才能使用
 *     4.程序自己写算法（不能重复）
 *
 *     Twitter Snowflake算法　JAVA实现方案
 * </pre>
 * 核心代码为其IdWorker这个类实现，其原理结构如下，分别用一个0表示一位，用-分割开部分的作用：
 * 1||0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
 * 在上面的字符串中，第一位为未使用（实际上也可作为long的符号位），接下来的41位为毫秒级时间，
 * 然后5位datacenter标识位，5位机器ID（并不算标识符，实际是为线程标识），
 * 然后12位该毫秒内的当前毫秒内的计数，加起来刚好64位，为一个Long型。
 * 这样的好处是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞（由datacenter和机器ID作区分），
 * 并且效率较高，经测试，snowflake每秒能够产生26万ID左右，完全满足需要。
 * <p>
 * 64位ID (42(毫秒)+5(机器ID)+5(业务编码)+12(重复累加))
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/29 23:40
 */
public class IdWorker {

    /**
     * 主机和进程的机器码
     */
    private static IdentifierGenerator IDENTIFIER_GENERATOR = new IdentifierGenerator();

    /**
     * 毫秒格式化时间
     */
    public static final DateTimeFormatter MILLISECOND = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    /**
     * 获取唯一ID
     *
     * @return id
     */
    public static long getId() {
        return getId(new Object());
    }

    /**
     * 获取唯一ID
     *
     * @return id
     */
    public static long getId(Object entity) {
        return IDENTIFIER_GENERATOR.nextId(entity).longValue();
    }

    /**
     * 获取唯一ID
     *
     * @return id
     */
    public static String getIdStr() {
        return getIdStr(new Object());
    }

    /**
     * 获取唯一ID
     *
     * @return id
     */
    public static String getIdStr(Object entity) {
        return IDENTIFIER_GENERATOR.nextId(entity).toString();
    }

    /**
     * 格式化的毫秒时间
     */
    public static String getMillisecond() {
        return LocalDateTime.now().format(MILLISECOND);
    }

    /**
     * 时间 ID = Time + ID
     * <p>例如：可用于商品订单 ID</p>
     */
    public static String getTimeId() {
        return getMillisecond() + getIdStr();
    }

    /**
     * 有参构造器
     *
     * @param workerId     工作机器 ID
     * @param dataCenterId 序列号
     */
    public static void initSequence(long workerId, long dataCenterId) {
        IDENTIFIER_GENERATOR = new IdentifierGenerator(workerId, dataCenterId);
    }

    /**
     * 自定义id 生成方式
     *
     * @param identifierGenerator id 生成器
     */
    public static void setIdentifierGenerator(IdentifierGenerator identifierGenerator) {
        IDENTIFIER_GENERATOR = identifierGenerator;
    }

    /**
     * 使用ThreadLocalRandom获取UUID获取更优的效果 去掉"-"
     */
    public static String get32UUID() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString().replace("-", "");
    }
}
