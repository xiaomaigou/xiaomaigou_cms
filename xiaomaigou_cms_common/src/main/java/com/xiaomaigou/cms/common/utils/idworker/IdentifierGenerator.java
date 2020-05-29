package com.xiaomaigou.cms.common.utils.idworker;

/**
 * 生成器
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/29 23:41
 */
public class IdentifierGenerator {
    private final Sequence sequence;

    public IdentifierGenerator() {
        this.sequence = new Sequence();
    }

    public IdentifierGenerator(long workerId, long dataCenterId) {
        this.sequence = new Sequence(workerId, dataCenterId);
    }

    public IdentifierGenerator(Sequence sequence) {
        this.sequence = sequence;
    }

    /**
     * 生成Id
     *
     * @param entity 实体
     * @return
     */
    public Number nextId(Object entity) {
        return sequence.nextId();
    }
}
