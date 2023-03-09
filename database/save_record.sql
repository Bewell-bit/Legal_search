/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : legal-system

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/03/2023 18:39:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for save_record
-- ----------------------------
DROP TABLE IF EXISTS `save_record`;
CREATE TABLE `save_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `txt_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `txt_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(0) NOT NULL,
  `created_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `txt_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `current_page` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of save_record
-- ----------------------------
INSERT INTO `save_record` VALUES (30, 'd4697d2d0131478fb025ae5500c6bc89', '虎永军、杨军军罚金执行实施执行通知书', 2, '2023-01-28 19:36:35', '执行案件', 0);
INSERT INTO `save_record` VALUES (35, '6aa4ef21cd5c4ca0bb31ad57010d3d27', '张军军罚金一案执行裁定书', 2, '2023-01-28 20:01:01', '执行案件', 0);
INSERT INTO `save_record` VALUES (36, '5b10ac29862a45a1bb47ad25002ae0e2', '中国信达资产管理股份有限公司黑龙江省分公司与中国兵工物资黑龙江公司、中国兵器工业集团航空弹药研究院有限公司借款合同纠纷一审民事裁定书', 2, '2023-01-28 22:45:24', '民事案件', 0);
INSERT INTO `save_record` VALUES (38, '032bb913803f4f7a8cc1ad3a002b2354', '刘某危险驾驶一审刑事判决书', 2, '2023-01-29 10:58:05', '刑事案件', 1);
INSERT INTO `save_record` VALUES (39, '032becb1e9484f269a54ac94003b7040', '程杨洋窝藏、包庇罪一审刑事判决书', 2, '2023-01-29 10:58:07', '刑事案件', 1);
INSERT INTO `save_record` VALUES (40, '032bfb67baa64c6fa6f7ae1a014a8941', '张金山、张学平等故意伤害罪刑事一审刑事判决书', 2, '2023-01-29 10:58:09', '刑事案件', 1);
INSERT INTO `save_record` VALUES (41, '032c39910b7c44e7aa20ae460012e2ff', '宋起义刑事一审刑事判决书', 2, '2023-01-29 10:58:11', '刑事案件', 1);
INSERT INTO `save_record` VALUES (53, '03402f861b684f92aa67ac6100a4cb82', '焦波伟非法采矿罪一审刑事判决书', 2, '2023-01-29 10:58:59', '刑事案件', 1);
INSERT INTO `save_record` VALUES (54, '0349fc89cf664017b106ad3d015c7a14', '芦明江危险驾驶罪一审刑事判决书', 2, '2023-01-29 10:59:04', '刑事案件', 5);
INSERT INTO `save_record` VALUES (55, '0f7ce7e8796d49f58ac6ad52002b3809', '狮桥融资租赁（中国）有限公司与中国大地财产保险股份有限公司哈尔滨市松北支公司、中国大地财产保险股份有限公司哈尔滨中心支公司财产保险合同纠纷一审民事裁定书', 2, '2023-01-29 11:12:26', '民事案件', 0);
INSERT INTO `save_record` VALUES (56, '7cc6377de861433f9716acfb011fedd5', '赵中国罚金执行通知书', 2, '2023-01-29 11:12:28', '执行案件', 0);
INSERT INTO `save_record` VALUES (57, 'c4adcb1f8d5a41d09631adb3009d3dec', '中国一冶集团有限公司上海分公司、中国一冶集团有限公司等债权转让合同纠纷民事一审民事裁定书', 2, '2023-01-29 11:12:30', '民事案件', 0);
INSERT INTO `save_record` VALUES (58, '28fea06216124aac95ddac5000b196b6', '贺艳军与杨军军借款合同纠纷一案民事裁定书', 2, '2023-01-29 11:12:43', '民事案件', 0);
INSERT INTO `save_record` VALUES (59, 'c6d6320d43c2459bb912ad3601331b35', '李静与被执行人祝军军、辛军红民间借贷纠纷一案执行裁定书', 2, '2023-01-29 11:12:45', '执行案件', 0);
INSERT INTO `save_record` VALUES (60, 'acff111e964f47ab9e42ac9900943d74', '李军军罚金一案执行裁定书', 2, '2023-01-29 11:12:47', '执行案件', 0);
INSERT INTO `save_record` VALUES (61, '000cca16e5f14967844fadcd00a6bb44', '庞龙龙、李小娥等金融借款合同纠纷民事一审民事判决书', 2, '2023-01-29 12:25:11', '民事案件', 0);
INSERT INTO `save_record` VALUES (64, '031ae11d84214468af27ac6200a80b9c', '哈冬聚众斗殴罪刑事裁定书', 2, '2023-01-30 23:15:02', '刑事案件', 16);
INSERT INTO `save_record` VALUES (65, '032ab6f88e88496db13cac78014a8f4d', '雷菊兰与新华人寿保险股份有限公司武功支公司保险纠纷一审民事裁定书', 2, '2023-01-30 23:15:10', '民事案件', 1);
INSERT INTO `save_record` VALUES (66, '032c9c56586d4ea1883cac6c0032ff63', '大庆市住房公积金管理中心、哈尔滨中央红集团股份有限公司大庆中央商城非诉执行审查行政裁定书', 2, '2023-01-30 23:15:16', '行政案件', 1);
INSERT INTO `save_record` VALUES (67, '032ad4964acd4ec7ade3ae1c0012831c', '朱发、冯国范借款合同纠纷恢复执行执行裁定书', 2, '2023-01-30 23:15:20', '执行案件', 1);
INSERT INTO `save_record` VALUES (68, '03144030689447e5b3e5adad008e01de', '白阳生、中国联合网络通信有限公司宝鸡市分公司合同纠纷一案的结案通知书', 2, '2023-01-30 23:15:25', '其他案件', 1);
INSERT INTO `save_record` VALUES (69, '02d7e22f883241679107adb200c923d8', '康伟罚金首次执行执行裁定书', 2, '2023-01-31 23:06:52', '其他案件', 1);
INSERT INTO `save_record` VALUES (70, '032ff677748c42058c61ac220031ce37', '双鸭山市环境卫生服务中心申请刘福记私房菜馆行政非诉案由非诉执行审查行政裁定书', 2, '2023-01-31 23:43:20', '行政案件', 1);
INSERT INTO `save_record` VALUES (71, '03303b419ca8473c8fe7ac52015d86ac', '柏丽平与西安市自然资源和规划局其他一审行政裁定书', 2, '2023-01-31 23:43:23', '行政案件', 1);
INSERT INTO `save_record` VALUES (72, '033475ed8fcf44faba63ab4900351a4e', '鸡东县人力资源和社会保障局、黑龙江蓝天建设集团有限公司富裕分公司非诉执行审查行政裁定书', 2, '2023-01-31 23:43:24', '行政案件', 1);
INSERT INTO `save_record` VALUES (73, '035310dd727441a78ee9abb400362b3e', '龙江县人民政府、杜志伦非诉执行审查行政裁定书', 2, '2023-01-31 23:43:26', '行政案件', 1);
INSERT INTO `save_record` VALUES (74, '033773bf5af748839afeac8e003c28f6', '柞水县自然资源局与韩忠礼其他非诉执行审查行政裁定书', 2, '2023-01-31 23:44:10', '行政案件', 6);
INSERT INTO `save_record` VALUES (75, '03359ced103d42b8b0d5ac92002b454d', '通河县林业和草原局、王洪乾非诉执行审查行政裁定书', 2, '2023-01-31 23:44:12', '行政案件', 6);
INSERT INTO `save_record` VALUES (76, '03209198de9048ebb652abf001612a0e', '胡刚与西安市财政局信息公开一审行政判决书', 2, '2023-01-31 23:44:14', '行政案件', 6);
INSERT INTO `save_record` VALUES (77, '032ab183fc55440f89a4ac33013080f3', '王玉兰与史发旺劳务合同纠纷执行实施类结案通知书', 2, '2023-01-31 23:44:48', '执行案件', 1);
INSERT INTO `save_record` VALUES (78, '032aecc7f402463ea604abc800bdafd6', '安康市生态环境局与岚皋县汉源生态农业发展有限公司行政非诉执行执行裁定书', 2, '2023-01-31 23:44:49', '执行案件', 1);
INSERT INTO `save_record` VALUES (79, '032b0e02df0c4caa93a1abba00ab533b', '青海中意门业有限责任公司与江苏中昶信建设集团有限公司合同、无因管理、不当得利执行实施类执行通知书', 2, '2023-01-31 23:44:51', '执行案件', 1);
INSERT INTO `save_record` VALUES (80, '032b127a9e1847e990d8acc700a5d8eb', '邓凯元与项杰才让借款合同纠纷执行实施类执行裁定书', 2, '2023-01-31 23:44:53', '执行案件', 1);
INSERT INTO `save_record` VALUES (81, '00e3191bec82460cb1b3adb201383b66', '赵喜、孙庆宏借款合同纠纷首次执行执行裁定书', 2, '2023-01-31 23:46:11', '其他案件', 1);
INSERT INTO `save_record` VALUES (82, '0036100ef5274b0a9318adb200e74a9b', '刘铁牛、连亚军等借款合同纠纷首次执行结案通知书', 2, '2023-01-31 23:46:13', '其他案件', 1);
INSERT INTO `save_record` VALUES (84, '025af9cfaa904d7998a3ada200e86482', '荆战军与 陕西华升绿州置业有限公司劳动争议结案报告(上网稿)', 2, '2023-01-31 23:46:18', '其他案件', 2);
INSERT INTO `save_record` VALUES (85, '032b25c3aa614972b3a9ae150017cd27', '中国工商银行股份有限公司哈尔滨靖宇支行、刘淑艳银行卡纠纷首次执行执行裁定书', 2, '2023-01-31 23:46:25', '执行案件', 5);
INSERT INTO `save_record` VALUES (86, '032b409818b6455e9645ae4b0065ea51', '袁文柱、邓清明劳务合同纠纷执行实施执行通知书', 2, '2023-01-31 23:46:26', '执行案件', 5);
INSERT INTO `save_record` VALUES (88, '940e3b390a154dd69a21ad060032fdf6', '陈建鑫诈骗一审刑事判决书', 2, '2023-02-04 17:29:14', '刑事案件', 1);
INSERT INTO `save_record` VALUES (89, '940e3b390a154dd69a21ad060032fdf6', '陈建鑫诈骗一审刑事判决书', 1, '2023-02-05 23:18:19', '刑事案件', 1);
INSERT INTO `save_record` VALUES (90, '9405d08a101d420bba95ac9d0034272e', '秦有军危险驾驶一审刑事判决书', 1, '2023-02-05 23:18:21', '刑事案件', 1);
INSERT INTO `save_record` VALUES (91, '940a15fe7c724f6db41aae080017a077', '杨宇轩挪用公款罪刑事再审刑事判决书', 1, '2023-02-05 23:18:23', '刑事案件', 1);
INSERT INTO `save_record` VALUES (92, '940c7a12aa07455b990eac85002b3735', '哈尔滨市亚联财小额贷款有限公司与董国峰借款合同纠纷一审民事判决书', 1, '2023-02-05 23:18:33', '民事案件', 1);
INSERT INTO `save_record` VALUES (93, '940c687d5513423cb1c2adb3008fb94b', '杨培雄、樊小平等金融借款合同纠纷民事一审民事判决书', 1, '2023-02-05 23:18:34', '民事案件', 1);
INSERT INTO `save_record` VALUES (94, '940a1ce18c4049c296ddade40014a18c', '大庆市龙凤区郭久养殖场、大庆市龙凤区应急管理局畜牧行政管理(畜牧)行政一审行政裁定书', 1, '2023-02-05 23:18:37', '行政案件', 1);
INSERT INTO `save_record` VALUES (95, '9408aa74c29d43f08cbbac14015babaa', '王番利与西安市灞桥区人民政府新合街道办事处信息公开一审行政裁定书', 1, '2023-02-05 23:18:39', '行政案件', 1);
INSERT INTO `save_record` VALUES (96, '940a7dc010654f1f942dac1e0133fcb9', '马铜仓与华州区瓜坡镇人民政府,渭南市华州区经济贸易合作局,渭南市华州区自然资源局不服土地管理拆除建筑物处罚一审行政判决书', 1, '2023-02-05 23:18:40', '行政案件', 1);
INSERT INTO `save_record` VALUES (97, '940c7ee9f0764e4f8084ae410011ada3', '吴沈辉其他案由首次执行执行通知书', 1, '2023-02-05 23:18:46', '执行案件', 1);
INSERT INTO `save_record` VALUES (98, '940c96bbb6a54967a9c4ae4b0065d2e6', '何建国、青海诺垚建筑装饰工程有限公司等民间借贷执行实施执行裁定书', 1, '2023-02-05 23:18:47', '执行案件', 1);
INSERT INTO `save_record` VALUES (99, '940cddc99fc941bbb4a9ad570102eb9b', '张继富与大庆昆仑唐人商业投资有限公司房屋买卖合同纠纷一案结案通知书', 1, '2023-02-05 23:18:50', '执行案件', 1);
INSERT INTO `save_record` VALUES (100, '954b8f8d6fc140a9831fada6014b7001', '和战权、宜君县林业局罚款非诉行政行为申请执行审查行政裁定书', 1, '2023-02-05 23:19:11', '其他案件', 1);
INSERT INTO `save_record` VALUES (101, '94576a507cef4e7e8aefadb3009924fa', '梁川、中国农业银行股份有限公司眉县支行银行卡纠纷首次执行执行裁定书', 1, '2023-02-05 23:19:12', '其他案件', 1);
INSERT INTO `save_record` VALUES (102, '93f09c722fa54e8f848eadb200eb62c3', '张晗坤、张晗坤等借款合同纠纷恢复执行结案通知', 1, '2023-02-05 23:19:14', '其他案件', 1);
INSERT INTO `save_record` VALUES (103, 'c7f87f6d53184473be80fc4a933040d5', '中国民用飞机开发有限公司与广州市迅辉能源有限公司买卖合同纠纷一审民事裁定书', 2, '2023-02-13 23:46:08', '民事案件', 0);
INSERT INTO `save_record` VALUES (104, 'ff655aee0dfe47158c80ac0601868689', '中国某集团公司、中国某集团公司分公司买卖合同纠纷其他民事裁定书', 2, '2023-02-16 19:32:34', '民事案件', 0);
INSERT INTO `save_record` VALUES (105, '3da4033c61a847a996bcac4200269482', '中国联合网络通信有限公司河北省分公司、中国联合网络通信有限公司石家庄市分公司、中国联合网络通信有限公司邯郸市分公司等其他案由执行实施类执行裁定书', 2, '2023-02-16 19:32:36', '执行案件', 0);
INSERT INTO `save_record` VALUES (107, 'fb3591df89484756b957ea6ce9c107c8', '黄某某、黄某甲、黄某乙、郭某某、黄某、黄某丙与黄某丁、黄某戊、黄某己、黄某庚、黄某辛法定继承纠纷一审民事裁定书', 2, '2023-02-18 16:56:06', '民事案件', 0);
INSERT INTO `save_record` VALUES (108, 'fd98a408f89642f79034a90a00e194e4', '黄某甲诉黄某乙、黄某丙、黄某丁、黄戊、黄己、黄庚、张某继承纠纷一审民事判决书', 2, '2023-02-18 16:56:12', '民事案件', 0);
INSERT INTO `save_record` VALUES (109, '087322881a4c43ce863eab3401035188', '黄志勇与黄建雄、黄桂海及第三人黄桂湘、黄榕湘、黄雪枚、黄林湘、黄桂洋房屋买卖合同纠纷一案一审民事判决书', 2, '2023-02-18 16:56:19', '民事案件', 0);
INSERT INTO `save_record` VALUES (110, '5636b1ada3a0461bb423a8e20120517a', '刘振行与中国中国人寿财产保险股份有限公司安阳中心支公司、中国人寿财产保险股份有限公司郑州中心支公司财产保险合同纠纷一审民事判决书', 2, '2023-02-18 18:04:31', '民事案件', 0);
INSERT INTO `save_record` VALUES (111, '9365a7760b4c4c9fafa6ad74000b39cd', '东芝电梯（中国）有限公司与中国新兴建筑工程有限责任公司承揽合同纠纷一审民事裁定书', 2, '2023-02-18 18:06:20', '民事案件', 0);
INSERT INTO `save_record` VALUES (112, '8ddd604a2fec49598ae3a9c60121391f', '孙素丽与中国平安人寿保险股份有限公司、中国平安人寿保险股份有限公司河南分公司人身保险合同纠纷一审民事裁定书', 2, '2023-02-18 18:18:24', '民事案件', 0);
INSERT INTO `save_record` VALUES (113, '113e9278fea24c3cb5b7ac75018100bf', '沅江广通大酒店有限公司与沅江市人力资源和社会保障局劳动和社会保障行政管理(劳动、社会保障)一审行政判决书', 2, '2023-02-18 23:42:54', '行政案件', 0);
INSERT INTO `save_record` VALUES (114, '1128c9ed14854ca69b34ad95002e82f0', '熊某与李某3、中国人民财产保险股份有限公司白银市平川支公司交通肇事罪一审刑事判决书', 2, '2023-02-20 15:52:06', '刑事案件', 1);
INSERT INTO `save_record` VALUES (115, '2247072f68e3446c8071ac3f00955850', '罗忠志、王在富等非法狩猎一审刑事判决书', 2, '2023-02-20 19:52:20', '刑事案件', 0);
INSERT INTO `save_record` VALUES (116, '898478ddd4c64fd9ad0ea8f100f92bf5', '原告肖中国与被告某（中国）贸易有限公司、某制药（中国）有限公司网络购物合同纠纷一审民事裁定书', 2, '2023-02-20 22:30:25', '民事案件', 0);
INSERT INTO `save_record` VALUES (117, '545c0b8444e14da5b3bba78b010fb490', '杨爱军与贾彦军、贾军军民间借贷纠纷一审民事判决书', 2, '2023-02-27 22:39:34', '民事案件', 0);
INSERT INTO `save_record` VALUES (118, 'bf318d9330064738899bacfb0032c36d', '唐军与蒋军军劳务合同纠纷一审民事判决书', 2, '2023-02-27 22:40:03', '民事案件', 0);
INSERT INTO `save_record` VALUES (119, '2df8429fa95a4918906ba98c013c7722', '张军军与霍爱军买卖合同纠纷一审民事判决书', 2, '2023-02-27 22:40:04', '民事案件', 0);
INSERT INTO `save_record` VALUES (120, '02350c5f22484fae8c13ac5d00099e59', '中国人事出版社有限公司与北京远东建业技术培训有限公司申请与前财产保全民事裁定书', 2, '2023-02-27 22:51:35', '民事案件', 0);
INSERT INTO `save_record` VALUES (121, 'ec6892c103f2419bb62fac5d00099d99', '中国人事出版社有限公司与北京远东建业技术培训有限公司申请与前财产保全民事裁定书', 2, '2023-02-27 22:51:38', '民事案件', 0);
INSERT INTO `save_record` VALUES (122, 'e40ec40262ba4c6892c4936362ed4ce3', '中国有色金属建设股份有限公司与杨邕等申请与前财产保全民事裁定书', 2, '2023-02-27 22:51:42', '非诉保全审查案件', 0);
INSERT INTO `save_record` VALUES (123, '112b51abdf87462cb3daad8200c53030', '马某某诈骗案一审刑事判决书', 2, '2023-02-28 12:52:18', '刑事案件', 0);
INSERT INTO `save_record` VALUES (124, '112a20bf428a41f3a831abe401876d84', '晏志钢危险驾驶一审刑事判决书', 2, '2023-02-28 12:52:21', '刑事案件', 0);
INSERT INTO `save_record` VALUES (126, '112ec037108c4e408d4babd101841944', '长沙市交通行政执法局、长沙市交通行政执法局认定被申请人欧阳新其非法运营其他行政裁定书', 2, '2023-03-04 10:40:10', '行政案件', 0);
INSERT INTO `save_record` VALUES (127, '1db691fc86054c8eaa47a85501638784', '孔中国刑事判决书', 2, '2023-03-04 11:18:54', '刑事案件', 0);

SET FOREIGN_KEY_CHECKS = 1;
