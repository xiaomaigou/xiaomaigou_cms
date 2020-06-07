/*
 Navicat Premium Data Transfer

 Source Server         : 99master
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 192.168.199.99:3306
 Source Schema         : xiaomaigoucmsdb

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 07/06/2020 22:03:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content`  (
  `content_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容ID',
  `content_category_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容分类code',
  `content_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容标题',
  `content_subtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容副标题',
  `content_description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容描述',
  `content_url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容链接',
  `content_pic` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片绝对路径',
  `original_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '商品原始价格,单位:元',
  `coupon_amount` decimal(20, 2) NULL DEFAULT NULL COMMENT '优惠券金额,单位:元',
  `sort_order` int(9) NULL DEFAULT NULL COMMENT '排序',
  `source_type_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '来源code',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `create_person_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `status` int(1) NOT NULL COMMENT '状态，-1删除，0无效，1有效',
  PRIMARY KEY (`content_id`) USING BTREE,
  INDEX `category_id`(`content_category_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '内容（广告）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_content
-- ----------------------------
INSERT INTO `tb_content` VALUES ('11', '1', '广告', NULL, NULL, 'https://www.baidu.com/', 'http://192.168.199.103/group1/M00/00/00/wKjHZ1uKlf2AC92WAAFyVK2N7Ig595.jpg', NULL, NULL, 9, '1', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_content` VALUES ('15', '1', '优惠,优惠券,优惠券折扣', NULL, NULL, 'https://mos.m.taobao.com/union/Clarks--pc?pid=mm_434580033_555150379_109013800489&site=4', 'https://img.alicdn.com/imgextra/i1/2053469401/O1CN01bjQPgw2JJhyswzTPi_!!2053469401.jpg', NULL, NULL, 7, '1', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('16', '1', '首页广告', NULL, NULL, 'http://www.xiaomaigou.com', 'http://192.168.199.103/group1/M00/00/00/wKjHZ1uKlgeAZi4-AAJLX6bBPuo183.jpg', NULL, NULL, 15, '1', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_content` VALUES ('17', '1', '优惠,优惠券,优惠券折扣', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DfMB8EAckfaccQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS8Ohl8Aids%2Fg8Inu2ylCdd8xquIk%2Fg7%2BcMvIAIHRmVEk3aH9JtUKSe2efZpbDTKrseayXL8WiT3B81iRVmz4ZI9EHgRZ3XGN7t7bpFLVJh6mn3nQvlcnYCVin5i48dot7Sk8VUKOm1BgrB9RdT6N3%2Bwl0VfTTYjkA%2FXpq5c2kX6bZJB2NJ00z5%2BQfCmbM%2Fq1qqC9QLJiaF9BA%3D%3D&pvid=23116944&union_lens=lensId:0b015dd6_0c6d_16e21caec9d_7789&site=0', 'https://img.alicdn.com/imgextra/i2/2053469401/O1CN01HACBCr2JJhz0VS1in_!!2053469401.jpg', NULL, NULL, 1, '1', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('18', '1', '优惠,优惠券,优惠券折扣', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DOpqQxVOGNV0cQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pyvTW5l3DCD33WHtde0jnhWuBURhOzFBCBeSJVZsUi%2BKJ8XaY204ddb7%2F1IwPk04o6RGvi26mAN1cE42ufXWKg3cIhH6qieDISG1kYtrC7hgVEq9I8IcNygcSpj5qSCmbA%3D&pvid=23116944&union_lens=lensId:0b57ab6b_0be4_16e21caecb6_7faf&site=1', 'https://img.alicdn.com/imgextra/i1/2053469401/O1CN01JpMhMC2JJhysYPRye_!!2053469401.jpg', NULL, NULL, 2, '1', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('19', '1', '优惠,优惠券,优惠券折扣', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DGS0lq62AvUscQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pyvTW5l3DCD32D%2FWiyO%2FCfTb6vvlZ%2B%2Bp5k7H841QwgXjhGEmKOt%2BbvROsIkmqRCprTreHkggu7Fu8MWOMwcRpjFCoPyNrmrfvF7ZP2CH%2FXkbxRblmWA5ZKv8m83sEANzu8%3D&pvid=23116944&union_lens=lensId:0b57b770_0c1b_16e21caeccd_9f03&site=2', 'https://img.alicdn.com/imgextra/i2/2053469401/O1CN01CPNMiw2JJhyx7NBCy_!!2053469401.jpg', NULL, NULL, 3, '1', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('20', '1', '优惠,优惠券,优惠券折扣', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DWrPRZD%2FWnfYcQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pyvTW5l3DCD33WHtde0jnhWuBURhOzFBCBeSJVZsUi%2BKJ8XaY204ddb7%2F1IwPk04o6RGvi26mAN1U8QzqNHM5BVD72JvEtfqauG1kYtrC7hgVEq9I8IcNygcSpj5qSCmbA%3D&pvid=23116944&union_lens=lensId:0b0130fe_0c49_16e21caecf3_ac75&site=3', 'https://img.alicdn.com/imgextra/i3/2053469401/O1CN01Ej3e7Z2JJhytL4TkN_!!2053469401.jpg', NULL, NULL, 5, '1', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('22', '2', '品牌优惠券,找优惠券,优惠券领取,购物', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DfMB8EAckfaccQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS8Ohl8Aids%2Fg8Inu2ylCdd8xquIk%2Fg7%2BcMvIAIHRmVEk3aH9JtUKSe2efZpbDTKrseayXL8WiT3B81iRVmz4ZI9EHgRZ3XGN7t7bpFLVJh6mn3nQvlcnYCVin5i48dot7Sk8VUKOm1BgrB9RdT6N3%2Bwl0VfTTYjkA%2FXpq5c2kX6bZJB2NJ00z5%2BQfCmbM%2Fq1qqC9QLJiaF9BA%3D%3D&pvid=23116944&union_lens=lensId:0b015dd6_0c6d_16e21caec9d_7789', 'https://img.alicdn.com/imgextra/i1/2053469401/O1CN01k1gHuA2JJhysI4Fz1_!!2053469401.jpg', NULL, NULL, 1, '1', NULL, NULL, NULL, '2020-03-23 22:16:45', NULL, '2020-03-23 22:16:48', 1);
INSERT INTO `tb_content` VALUES ('23', '2', '限时秒杀,折扣,特卖,品牌特卖', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3D6U635jND2a0cQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pyvTW5l3DCD33WHtde0jnhWuBURhOzFBCBeSJVZsUi%2BKJ8XaY204ddb7%2F1IwPk04o7wMqzEyCHn5oYWXthwUuVEBB4pRmb5vmyWBYkp3RNWaReKwctUTQNYomfkDJRs%2BhU%3D&pvid=23116944&union_lens=lensId:0b57b5a6_0c4d_16e21caed28_a725', 'https://img.alicdn.com/imgextra/i4/2053469401/O1CN01o2Y5v22JJhyqNccnZ_!!2053469401.jpg', NULL, NULL, 2, '1', NULL, NULL, NULL, '2020-03-23 22:17:36', NULL, '2020-03-23 22:17:38', 1);
INSERT INTO `tb_content` VALUES ('24', '2', '网购省钱,抢购,秒杀', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3D9nHlaEZ0BAIcQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pyvTW5l3DCD32D%2FWiyO%2FCfTb6vvlZ%2B%2Bp5k7H841QwgXjhGEmKOt%2BbvROsIkmqRCprTreHkggu7Fu8MWOMwcRpjFxfgWHpb1s%2Fx7ZP2CH%2FXkbxRblmWA5ZKv8m83sEANzu8%3D&pvid=23116944&union_lens=lensId:0b012f08_0c2b_16e21caed45_4307', 'https://img.alicdn.com/imgextra/i4/2053469401/O1CN01OVChCF2JJhyujEv61_!!2053469401.jpg', NULL, NULL, 3, '1', NULL, NULL, NULL, '2020-03-23 22:18:25', NULL, '2020-03-23 22:18:28', 1);
INSERT INTO `tb_content` VALUES ('25', '3', '半价,5折,淘抢购,聚划算', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DVxXHNE1Dk5IcQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pziLK97AJ37xOTEWgyms0M1sQ8hcK%2FYPF5JXWJQTx5IVOuCdKWDjb%2BWYcUSK79LRiV6DTFwaWexu%2BeWClVZqtTxWBIX83bU20jGDF1NzTQoPw%3D%3D&pvid=23116944&union_lens=lensId:0b0ae8da_0bd8_16e21caed5f_bfd3', 'https://img.alicdn.com/imgextra/i1/2053469401/O1CN01LYGhFG2JJhyo0cJze_!!2053469401.jpg', NULL, NULL, 1, '1', NULL, NULL, NULL, '2020-03-23 22:55:14', NULL, '2020-03-23 22:55:28', 1);
INSERT INTO `tb_content` VALUES ('26', '4', '冬季大码男装中长款连帽棉服', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=xoLfDqQfmWsE%2BdAb1JoOOu5SCX9vIcfolaJqH0iJOZXDdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2BT3b4zuHjpz1ug731VBEQm4W4aFJRXLDFlmT5swLWTvOh4LHcmKitzZeF9VVoymod9YheSWFBwhsjNTNKaKKWQ%3D&traceId=0b0f5f1715725350219901091e&union_lens=lensId:0b17774d_0c1f_16e226431c4_0669&xId=TnvmlS6bF6FSJzuUAQcpzip6ffguu57jqhmkhc1AwGXJhbVMn62VfgnIvQrY5gAFTCNEuOhfQYCfQNl31VbrE', NULL, NULL, NULL, NULL, '1', '拍下立减', '前1小时减20元', NULL, '2020-03-23 22:57:41', NULL, '2020-03-23 22:57:43', 1);
INSERT INTO `tb_content` VALUES ('27', '4', '防滑防水妈妈棉鞋', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DUqhGjKTzRN5w4vFB6t2Z2ueEDrYVVa64K7Vc7tFgwiHLWlSKdGSYDk9P0ejywBPzt4hWD5k2kjOp6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYSQYRxDRWsrMLVAfN61YjF9gJVtl4ZVDDowe6%2FtGg2%2FRSyiL934V8t5NFJMOTFqC%2BlPFeq0Ze80KfWsUjZoD5RD4udOCRToABKzWEZU7kU52qOfwg0zDYoNf8EoZsDl2OKJn5AyUbPoV&union_lens=lensId:0b01e6c4_0c72_16e2255dfb8_0647&xId=9HYXN2oRxnvPcsFEYlVzAUpJKiAXDY3SxmLpnZZSCiqayttvlEPaF96q1QiwS2itFHIiKacGXvAemFC3Y7ecbR', NULL, NULL, NULL, NULL, '1', '第二件半价', '前2小时', NULL, '2020-03-23 22:57:38', NULL, '2020-03-23 22:57:45', 1);
INSERT INTO `tb_content` VALUES ('28', '5', '抢购,秒杀,限时秒杀,折扣', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DuhHJT6WLCbwcQipKwQzePCperVdZeJviyK8Cckff7TVRAdhuF14FMRC8b%2FWr2ODOlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYVqQucxjw1fWu3ex8PaaVqDLP4XO97Tuip7xDSuPmzLWC2TKqEFvn7gehppSckYlU8tA8Qks8BYBXdZXtfxfyx3LwX6QQDBLP%2FEzZsDmO3irzueC0P1cNS%2B6zThPYvErzhJBFs1%2FyLxVPxey8%2Bhd8pyvTW5l3DCD32D%2FWiyO%2FCfTb6vvlZ%2B%2Bp5k7H841QwgXjhGEmKOt%2BbvROsIkmqRCprTreHkggu7Fu8MWOMwcRpjF1aDJTf8gMQl7ZP2CH%2FXkbxRblmWA5ZKv8m83sEANzu8%3D&pvid=23116944&union_lens=lensId:0b5952e0_0c29_16e21caed7a_b733', 'https://img.alicdn.com/imgextra/i2/2053469401/O1CN019o5jwK2JJhyozHG7I_!!2053469401.jpg', NULL, NULL, NULL, '1', NULL, NULL, NULL, '2020-03-23 22:58:52', NULL, '2020-03-23 22:58:54', 1);
INSERT INTO `tb_content` VALUES ('29', '4', '法国老藤佳酿', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DJ%2Bi2f6ToUz1w4vFB6t2Z2ueEDrYVVa64LKpWJ%2Bin0XLLWlSKdGSYDkMmZ33lkEnVlovu%2FCElQOup6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYSQYRxDRWsrMuNGZvH5RemgtkqnaC2xXHAtkyqhBb5%2B4HoaaUnJGJVP82p%2FOeAXvm7bfmOkXsCRdar4zUqKufJp%2FqGwOFzbHZNsnb%2BotVRe6xgxdTc00KD8%3D&union_lens=lensId:0b0b275f_0bf1_16e22624bd8_9275&xId=EFIcZvf6CUoPhxiZhOthmCOggYk5tprdLWeQQZRRwOAcrKKRuttK5KuRzwEaC9DZuyVYRTuQ6vCLt9Y9uBULy4', NULL, NULL, NULL, NULL, '1', '拍下立减', '前2小时减50元', NULL, '2020-03-23 23:19:20', NULL, '2020-03-23 23:19:26', 1);
INSERT INTO `tb_content` VALUES ('30', '4', '儿童内衣套装加厚保暖夹棉内衣', NULL, NULL, 'https://s.click.taobao.com/t?e=m%3D2%26s%3DtxD3%2B9EtDkFw4vFB6t2Z2ueEDrYVVa64K7Vc7tFgwiHLWlSKdGSYDgn0Duc3uOmrJ1gyddu7kN%2Bp6wkN%2B6RLqzvPcnR1STclY9x4HlyE5idLzg6OZt1NYSQYRxDRWsrMI3m%2FcfZ109aUBhogXFkTngtkyqhBb5%2B4x8PUddoNe3C1bHPVcm4MfXGfvOtEts6D4JOed0Rxa6NXD03VJYAcmSw29%2FczpxKYy8F%2BkEAwSz9YtwYciWq%2BycYl7w3%2FA2kb&union_lens=lensId:0b57bdf0_0c79_16e22547633_8b8b&xId=xCB1dQU6uFa18R7SW3Spxpssh214FX72nVI1hMZWLIFsYRmurcCCoT4YvDYnRJPnB6NLpPcxUZjWhSFvj9O2pc', NULL, NULL, NULL, NULL, '1', '拍下立减', '前500名减20元', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('31', '4', '高清双面化妆镜宿舍网红桌面镜', NULL, NULL, 'https://detail.tmall.com/item.htm?id=560729779388&pid=mm_434580033_555150379_109013800489', NULL, NULL, NULL, NULL, '1', '拍下半价', '前1000名', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('32', '4', '格子围巾加绒秋冬韩版时尚', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=S238mLPoZ7AGQASttHIRqSiMz%2BwOtHS6RMenv0eIfVzDdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngMmnVmWO1H8vvI9wRv%2BDqFlLajOROSSHlq%2B9absLo%2Bym6wrua89LTFw%3D%3D&traceId=0b17377a15725346025365433e&union_lens=lensId:0b57b76f_0c5d_16e225dcb41_b39b&xId=jt1OQksFDtkL4kf3CxVhDqKhQtdf9k5OjXoqbqinsQDdO3foBKIAw8W3OdGrZBbymR3WjkiQcyGvaMlCzMvh0D', NULL, NULL, NULL, NULL, '1', '领券立减', '月销2w+', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('33', '4', '嘉士利果乐果香夹心饼干680g', NULL, NULL, 'https://detail.tmall.com/item.htm?id=594097100883&pid=mm_434580033_555150379_109013800489', NULL, NULL, NULL, NULL, '1', '拍下立减', '2件减5元', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('34', '4', '日本少女心保温杯男女士小学生', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=8%2BA1VlTMJUEGQASttHIRqQ2slrmehrCEkHbNlwS4IO7DdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2BT3b4zuHjpz1ug731VBEQm4W4aFJRXLDPstrKIPpRBjAJtV5SE2TVoxVANndQGLnW2XSYDfQHcuNkxtLfloMFuynwS%2B%2FF8NWQ%3D%3D&traceId=0b183a2d15725339813052276e&union_lens=lensId:0b0ad760_0c5d_16e22545099_8403&xId=pml7bQ45JtO9IoVIYCG8AJevnfnbp0ayfVeXpsx12JBkyelYjSiuf2KK8h2b8M9Ru0lFYcod6UwLaKvZ9oCggc', NULL, NULL, NULL, NULL, '1', '领券立减', '月销2.5w+', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('35', '4', '小浣熊儿童保湿面霜+唇膏', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=of3pdR9STdoE%2BdAb1JoOOveYtDmEgPsub5hZ0BNdupjDdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngMmnVmWO1H8vvI9wRv%2BDqFlLajOROSSHl%2FqtxVvixOH47cKmzsGca7w%3D%3D&traceId=0b0adafc15725339572054112e&union_lens=lensId:0b5797e0_0bb3_16e2253f26d_07b3&xId=dLEIxBlcpzm0xpbGjf5WZBRM4gQoPKOe6XIcnHfdO61Yb8jF89pfqUWDkNDYgNJbY5ewROFmeGLVzETotQDD9t&activityId=cc1b6069facc474290362cec8c49b6ea', NULL, NULL, NULL, NULL, '1', '第二件0元', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('36', '4', '哈尔滨红肠即食香肠', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=H3eQT%2B75t5kGQASttHIRqaIsbvyrQA%2BecOHP2A9DwmfDdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngMmnVmWO1H8vvI9wRv%2BDqFlLajOROSSHlVp0xXaYHBuKrQPntpspgCA%3D%3D&traceId=0b0fe8b515725343703774059e&union_lens=lensId:0b5797e2_0bcb_16e225a4061_ceb7&xId=ynWHBHLwi8o4adLz2MrGNn494FPi3MVkdfBN4myWZ2d7IAbTb59dWL00T95Or9A3e1dOQP8bpLlHtvIFtzzUO4&activityId=3beedc7212884361b9db278087208a92', NULL, NULL, NULL, NULL, '1', '第二件0元', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('37', '4', '159五谷杂粮全餐代餐粉', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=cj%2FaiQ4Q88wE%2BdAb1JoOOnsRfJT1WzgXOl%2BcP0drDLXDdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2BT3b4zuHjpz1ug731VBEQm1M7QmaYJz9PFaBe2GOkPYHvfjMSYvfkGji5Mwp8diMNX5t2gX2LiSyPqtMpPSTUX%2BD2muFqQmrOejOTeVvxqw&traceId=0b183fcb15725343113532039e&union_lens=lensId:0b0840e9_0cc5_16e225959d2_cf25&xId=J46LJArVhy0OrJ0X6TzcDhfilDYvow0NLALLHUe1L9ILuKds1mG7Hwi8R6RFLEaIsijZBVuiR9x4EXJQa9UfVb&activityId=031512e398ef4c349d99e80ae828192b', NULL, NULL, NULL, NULL, '1', '第二件半价', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('38', '4', '宝宝婴儿保暖内衣套装', NULL, NULL, 'https://uland.taobao.com/coupon/edetail?e=WxLUKkmDbZEE%2BdAb1JoOOkU%2BcRXpSsGfDmM8nsZLFnvDdQBKPs4TeVCPxxgh%2BgxUi8wU6BGnXiR%2ByBLz0qNIJEvCXXDum2KYY1kWovEdEWPKdDtLTN7C7%2FsnwWZGSCD41ug731VBEQm0m3Ckm6GN2CwynAdGnOngMmnVmWO1H8vvI9wRv%2BDqFlLajOROSSHlPf034Yj51kuRuZ4jkWYLiA%3D%3D&traceId=0b0f97c815725342075401109e&union_lens=lensId:0b0b97cd_0bf9_16e2257c44a_7679&xId=LqVvgJ8FxrwCLuootZl3wJ5ZuyE1HtZ5D4i2tEtHdmvT3I5iKT1zPhKK9hv1yHvoltPHxBfSF9YgDXmE7UJkod&activityId=028ab9bda129415aad5d743b201f822d', NULL, NULL, NULL, NULL, '1', '第二件半价', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('5', '7', '测试广告', NULL, NULL, 'http://www.baidu.com', 'http://192.168.199.103/group1/M00/00/00/wKjHZ1uKFxyAOMOmAADKwOEYD-s878.jpg', NULL, NULL, 3, '1', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_content` VALUES ('9', '1', '1元秒抢月饼', NULL, NULL, 'http://www.163.com', 'http://192.168.199.103/group1/M00/00/00/wKjHZ1uKle-AaIv7AAGD6NU_dsM334.jpg', NULL, NULL, 7, '1', NULL, NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_content_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_category`;
CREATE TABLE `tb_content_category`  (
  `content_category_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容分类ID',
  `content_category_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容分类code',
  `content_category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `create_person_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `update_person_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `status` int(1) NOT NULL COMMENT '状态，-1删除，0无效，1有效',
  PRIMARY KEY (`content_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '内容（广告）分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_content_category
-- ----------------------------
INSERT INTO `tb_content_category` VALUES ('1269581423760887810', '1', '首页轮播广告', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:46:14', '2020-06-07 18:46:14', 1);
INSERT INTO `tb_content_category` VALUES ('1269581503704322049', '2', '今日推荐', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:46:33', '2020-06-07 18:46:33', 1);
INSERT INTO `tb_content_category` VALUES ('1269581561401167873', '3', '活动专区', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:46:47', '2020-06-07 18:46:47', 1);
INSERT INTO `tb_content_category` VALUES ('1269581620624740354', '4', '猜你喜欢', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:47:01', '2020-06-07 18:47:01', 1);
INSERT INTO `tb_content_category` VALUES ('1269581670880890882', '5', '服装楼层广告', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:47:13', '2020-06-07 18:47:13', 1);

-- ----------------------------
-- Table structure for tb_helloworld
-- ----------------------------
DROP TABLE IF EXISTS `tb_helloworld`;
CREATE TABLE `tb_helloworld`  (
  `hw_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'HelloworldID',
  `hw_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `hw_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `hw_url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '链接',
  `hw_pic` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片绝对路径',
  `hw_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '价格,单位:元',
  `hw_sort_order` int(9) NULL DEFAULT NULL COMMENT '排序',
  `create_person_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person_id` bigint(20) NULL DEFAULT NULL COMMENT '最后修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态，0无效，1有效',
  PRIMARY KEY (`hw_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'helloworld信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_helloworld
-- ----------------------------
INSERT INTO `tb_helloworld` VALUES ('1', '小麦购', '小麦购商城(XiaoMaiGou.COM)-正品低价、品质保障、配送及时、轻松购物!专业的综合网上导购商城，包括京东、天猫、淘宝等优惠券商品精选，为您提供正品低价的特价商品、优质便捷的服务体验。商品来自全球数十万品牌商家，囊括家电、手机、电脑、服装、居家、母婴、美妆、个护、食品、生鲜等丰富品类，满足各种购物需求。', 'http://www.xiaomaigou.com', 'http://cdn.xiaomaicloud.com/logo/xiaomaigou/png/xiaomaigou_logo_png_640x199.png', 9.90, 1, 1, '2020-03-30 21:53:33', 1, '2020-03-30 21:53:38', 1);
INSERT INTO `tb_helloworld` VALUES ('2', '小麦云', '互联网重塑商业格局!', 'http://wwww.xiaomaicloud.com', 'http://cdn.xiaomaicloud.com/logo/xiaomaicloud/png/xiaomaicloud_logo_png_606x191.png', 29.90, 2, 1, '2020-03-30 21:58:04', 1, '2020-03-30 21:58:09', 1);

-- ----------------------------
-- Table structure for tb_source_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_source_type`;
CREATE TABLE `tb_source_type`  (
  `source_type_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '来源ID',
  `source_type_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '来源code',
  `source_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源名称',
  `create_person_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `update_person_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `status` int(1) NOT NULL COMMENT '状态，-1删除，0无效，1有效',
  PRIMARY KEY (`source_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '来源类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_source_type
-- ----------------------------
INSERT INTO `tb_source_type` VALUES ('1269577315402334209', '1', '小麦购', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:29:54', '2020-06-07 18:29:54', 1);
INSERT INTO `tb_source_type` VALUES ('1269577455722774529', '2', '淘宝', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:30:28', '2020-06-07 18:30:28', 1);
INSERT INTO `tb_source_type` VALUES ('1269577495090511873', '3', '天猫', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:30:37', '2020-06-07 18:30:37', 1);
INSERT INTO `tb_source_type` VALUES ('1269577544809791489', '4', '大淘客', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:30:49', '2020-06-07 18:30:49', 1);
INSERT INTO `tb_source_type` VALUES ('1269577575755366402', '5', '京东', 'xiaomaigou', 'xiaomaigou', '2020-06-07 18:30:56', '2020-06-07 18:30:56', 1);

SET FOREIGN_KEY_CHECKS = 1;
