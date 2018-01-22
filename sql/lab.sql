/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lab

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-20 22:57:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '学生姓名1', '学校1');
INSERT INTO `t_student` VALUES ('2', '学生姓名2', '学校2');
INSERT INTO `t_student` VALUES ('3', '学生姓名3', '学校3');
INSERT INTO `t_student` VALUES ('4', '学生姓名4', '学校4');
INSERT INTO `t_student` VALUES ('5', '学生姓名5', '学校5');
INSERT INTO `t_student` VALUES ('7', '学生姓名7', '学校7');
INSERT INTO `t_student` VALUES ('8', '学生姓名8', '学校8');
INSERT INTO `t_student` VALUES ('9', '学生姓名9', '学校9');
INSERT INTO `t_student` VALUES ('10', '学生姓名10', '学校10');
INSERT INTO `t_student` VALUES ('11', '学生姓名11', '学校11');
INSERT INTO `t_student` VALUES ('12', '学生姓名12', '学校12');
INSERT INTO `t_student` VALUES ('13', '学生姓名13', '学校13');
INSERT INTO `t_student` VALUES ('14', '学生姓名14', '学校14');
INSERT INTO `t_student` VALUES ('15', '学生姓名15', '学校15');
INSERT INTO `t_student` VALUES ('16', '学生姓名16', '学校16');
INSERT INTO `t_student` VALUES ('17', '学生姓名17', '学校17');
INSERT INTO `t_student` VALUES ('18', '学生姓名18', '学校18');
INSERT INTO `t_student` VALUES ('19', '学生姓名19', '学校19');
INSERT INTO `t_student` VALUES ('20', '学生姓名20', '学校20');
INSERT INTO `t_student` VALUES ('21', '学生姓名21', '学校21');
INSERT INTO `t_student` VALUES ('22', '学生姓名22', '学校22');
INSERT INTO `t_student` VALUES ('23', '学生姓名23', '学校23');
INSERT INTO `t_student` VALUES ('24', '学生姓名24', '学校24');
INSERT INTO `t_student` VALUES ('25', '学生姓名25', '学校25');
INSERT INTO `t_student` VALUES ('26', '学生姓名26', '学校26');
INSERT INTO `t_student` VALUES ('27', '学生姓名27', '学校27');
INSERT INTO `t_student` VALUES ('28', '学生姓名28', '学校28');
INSERT INTO `t_student` VALUES ('29', '学生姓名29', '学校29');
INSERT INTO `t_student` VALUES ('30', '学生姓名30', '学校30');
INSERT INTO `t_student` VALUES ('31', '学生姓名31', '学校31');
INSERT INTO `t_student` VALUES ('32', '学生姓名32', '学校32');
INSERT INTO `t_student` VALUES ('33', '学生姓名33', '学校33');
INSERT INTO `t_student` VALUES ('34', '学生姓名34', '学校34');
INSERT INTO `t_student` VALUES ('35', '学生姓名35', '学校35');
INSERT INTO `t_student` VALUES ('36', '学生姓名36', '学校36');
INSERT INTO `t_student` VALUES ('37', '学生姓名37', '学校37');
INSERT INTO `t_student` VALUES ('38', '学生姓名38', '学校38');
INSERT INTO `t_student` VALUES ('39', '学生姓名39', '学校39');
INSERT INTO `t_student` VALUES ('40', '学生姓名40', '学校40');
INSERT INTO `t_student` VALUES ('41', '学生姓名41', '学校41');
INSERT INTO `t_student` VALUES ('42', '学生姓名42', '学校42');
INSERT INTO `t_student` VALUES ('43', '学生姓名43', '学校43');
INSERT INTO `t_student` VALUES ('44', '学生姓名44', '学校44');
INSERT INTO `t_student` VALUES ('45', '学生姓名45', '学校45');
INSERT INTO `t_student` VALUES ('46', '学生姓名46', '学校46');
INSERT INTO `t_student` VALUES ('47', '学生姓名47', '学校47');
INSERT INTO `t_student` VALUES ('48', '学生姓名48', '学校48');
INSERT INTO `t_student` VALUES ('49', '学生姓名49', '学校49');
INSERT INTO `t_student` VALUES ('50', '学生姓名50', '学校50');
INSERT INTO `t_student` VALUES ('51', '学生姓名51', '学校51');
INSERT INTO `t_student` VALUES ('52', '学生姓名52', '学校52');
INSERT INTO `t_student` VALUES ('53', '学生姓名53', '学校53');
INSERT INTO `t_student` VALUES ('54', '学生姓名54', '学校54');
INSERT INTO `t_student` VALUES ('55', '学生姓名55', '学校55');
INSERT INTO `t_student` VALUES ('56', '学生姓名56', '学校56');
INSERT INTO `t_student` VALUES ('57', '学生姓名57', '学校57');
INSERT INTO `t_student` VALUES ('58', '学生姓名58', '学校58');
INSERT INTO `t_student` VALUES ('59', '学生姓名59', '学校59');
INSERT INTO `t_student` VALUES ('60', '学生姓名60', '学校60');
INSERT INTO `t_student` VALUES ('61', '学生姓名61', '学校61');
INSERT INTO `t_student` VALUES ('62', '学生姓名62', '学校62');
INSERT INTO `t_student` VALUES ('63', '学生姓名63', '学校63');
INSERT INTO `t_student` VALUES ('64', '学生姓名64', '学校64');
INSERT INTO `t_student` VALUES ('65', '学生姓名65', '学校65');
INSERT INTO `t_student` VALUES ('66', '学生姓名66', '学校66');
INSERT INTO `t_student` VALUES ('67', '学生姓名67', '学校67');
INSERT INTO `t_student` VALUES ('68', '学生姓名68', '学校68');
INSERT INTO `t_student` VALUES ('69', '学生姓名69', '学校69');
INSERT INTO `t_student` VALUES ('70', '学生姓名70', '学校70');
INSERT INTO `t_student` VALUES ('71', '学生姓名71', '学校71');
INSERT INTO `t_student` VALUES ('72', '学生姓名72', '学校72');
INSERT INTO `t_student` VALUES ('73', '学生姓名73', '学校73');
INSERT INTO `t_student` VALUES ('74', '学生姓名74', '学校74');
INSERT INTO `t_student` VALUES ('75', '学生姓名75', '学校75');
INSERT INTO `t_student` VALUES ('76', '学生姓名76', '学校76');
INSERT INTO `t_student` VALUES ('77', '学生姓名77', '学校77');
INSERT INTO `t_student` VALUES ('78', '学生姓名78', '学校78');
INSERT INTO `t_student` VALUES ('79', '学生姓名79', '学校79');
INSERT INTO `t_student` VALUES ('80', '学生姓名80', '学校80');
INSERT INTO `t_student` VALUES ('81', '学生姓名81', '学校81');
INSERT INTO `t_student` VALUES ('82', '学生姓名82', '学校82');
INSERT INTO `t_student` VALUES ('83', '学生姓名83', '学校83');
INSERT INTO `t_student` VALUES ('84', '学生姓名84', '学校84');
INSERT INTO `t_student` VALUES ('85', '学生姓名85', '学校85');
INSERT INTO `t_student` VALUES ('86', '学生姓名86', '学校86');
INSERT INTO `t_student` VALUES ('87', '学生姓名87', '学校87');
INSERT INTO `t_student` VALUES ('88', '学生姓名88', '学校88');
INSERT INTO `t_student` VALUES ('89', '学生姓名89', '学校89');
INSERT INTO `t_student` VALUES ('90', '学生姓名90', '学校90');
INSERT INTO `t_student` VALUES ('91', '学生姓名91', '学校91');
INSERT INTO `t_student` VALUES ('92', '学生姓名92', '学校92');
INSERT INTO `t_student` VALUES ('93', '学生姓名93', '学校93');
INSERT INTO `t_student` VALUES ('94', '学生姓名94', '学校94');
INSERT INTO `t_student` VALUES ('95', '学生姓名95', '学校95');
INSERT INTO `t_student` VALUES ('96', '学生姓名96', '学校96');
INSERT INTO `t_student` VALUES ('97', '学生姓名97', '学校97');
INSERT INTO `t_student` VALUES ('98', '学生姓名98', '学校98');
INSERT INTO `t_student` VALUES ('99', '学生姓名99', '学校99');
INSERT INTO `t_student` VALUES ('100', '学生姓名100', '学校100');

-- ----------------------------
-- Table structure for t_student_article
-- ----------------------------
DROP TABLE IF EXISTS `t_student_article`;
CREATE TABLE `t_student_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_article
-- ----------------------------
INSERT INTO `t_student_article` VALUES ('8', '1', '文章标题1', '                        文章内容1\r\n        \r\n        ', '1513752556031association.png');
INSERT INTO `t_student_article` VALUES ('9', '2', '文章标题2', '文章内容2', null);
INSERT INTO `t_student_article` VALUES ('10', '3', '文章标题3', '文章内容3', null);
INSERT INTO `t_student_article` VALUES ('11', '4', '文章标题4', '文章内容4', null);
INSERT INTO `t_student_article` VALUES ('12', '5', '文章标题5', '文章内容5', null);
INSERT INTO `t_student_article` VALUES ('14', '7', '文章标题7', '文章内容7', null);
INSERT INTO `t_student_article` VALUES ('15', '8', '文章标题8', '文章内容8', null);
INSERT INTO `t_student_article` VALUES ('16', '9', '文章标题9', '文章内容9', null);
INSERT INTO `t_student_article` VALUES ('17', '10', '文章标题10', '文章内容10', null);
INSERT INTO `t_student_article` VALUES ('18', '11', '文章标题11', '文章内容11', null);
INSERT INTO `t_student_article` VALUES ('19', '12', '文章标题12', '文章内容12', null);
INSERT INTO `t_student_article` VALUES ('20', '13', '文章标题13', '文章内容13', null);
INSERT INTO `t_student_article` VALUES ('21', '14', '文章标题14', '文章内容14', null);
INSERT INTO `t_student_article` VALUES ('22', '15', '文章标题15', '文章内容15', null);
INSERT INTO `t_student_article` VALUES ('23', '16', '文章标题16', '文章内容16', null);
INSERT INTO `t_student_article` VALUES ('24', '17', '文章标题17', '文章内容17', null);
INSERT INTO `t_student_article` VALUES ('25', '18', '文章标题18', '文章内容18', null);
INSERT INTO `t_student_article` VALUES ('26', '19', '文章标题19', '文章内容19', null);
INSERT INTO `t_student_article` VALUES ('27', '20', '文章标题20', '文章内容20', null);
INSERT INTO `t_student_article` VALUES ('28', '21', '文章标题21', '文章内容21', null);
INSERT INTO `t_student_article` VALUES ('29', '22', '文章标题22', '文章内容22', null);
INSERT INTO `t_student_article` VALUES ('30', '23', '文章标题23', '文章内容23', null);
INSERT INTO `t_student_article` VALUES ('31', '24', '文章标题24', '文章内容24', null);
INSERT INTO `t_student_article` VALUES ('32', '25', '文章标题25', '文章内容25', null);
INSERT INTO `t_student_article` VALUES ('33', '26', '文章标题26', '文章内容26', null);
INSERT INTO `t_student_article` VALUES ('34', '27', '文章标题27', '文章内容27', null);
INSERT INTO `t_student_article` VALUES ('35', '28', '文章标题28', '文章内容28', null);
INSERT INTO `t_student_article` VALUES ('36', '29', '文章标题29', '文章内容29', null);
INSERT INTO `t_student_article` VALUES ('37', '30', '文章标题30', '文章内容30', null);
INSERT INTO `t_student_article` VALUES ('38', '31', '文章标题31', '文章内容31', null);
INSERT INTO `t_student_article` VALUES ('39', '32', '文章标题32', '文章内容32', null);
INSERT INTO `t_student_article` VALUES ('40', '33', '文章标题33', '文章内容33', null);
INSERT INTO `t_student_article` VALUES ('41', '34', '文章标题34', '文章内容34', null);
INSERT INTO `t_student_article` VALUES ('42', '35', '文章标题35', '文章内容35', null);
INSERT INTO `t_student_article` VALUES ('43', '36', '文章标题36', '文章内容36', null);
INSERT INTO `t_student_article` VALUES ('44', '37', '文章标题37', '文章内容37', null);
INSERT INTO `t_student_article` VALUES ('45', '38', '文章标题38', '文章内容38', null);
INSERT INTO `t_student_article` VALUES ('46', '39', '文章标题39', '文章内容39', null);
INSERT INTO `t_student_article` VALUES ('47', '40', '文章标题40', '文章内容40', null);
INSERT INTO `t_student_article` VALUES ('48', '41', '文章标题41', '文章内容41', null);
INSERT INTO `t_student_article` VALUES ('49', '42', '文章标题42', '文章内容42', null);
INSERT INTO `t_student_article` VALUES ('50', '43', '文章标题43', '文章内容43', null);
INSERT INTO `t_student_article` VALUES ('51', '44', '文章标题44', '文章内容44', null);
INSERT INTO `t_student_article` VALUES ('52', '45', '文章标题45', '文章内容45', null);
INSERT INTO `t_student_article` VALUES ('53', '46', '文章标题46', '文章内容46', null);
INSERT INTO `t_student_article` VALUES ('54', '47', '文章标题47', '文章内容47', null);
INSERT INTO `t_student_article` VALUES ('55', '48', '文章标题48', '文章内容48', null);
INSERT INTO `t_student_article` VALUES ('56', '49', '文章标题49', '文章内容49', null);
INSERT INTO `t_student_article` VALUES ('57', '50', '文章标题50', '文章内容50', null);
INSERT INTO `t_student_article` VALUES ('58', '51', '文章标题51', '文章内容51', null);
INSERT INTO `t_student_article` VALUES ('59', '52', '文章标题52', '文章内容52', null);
INSERT INTO `t_student_article` VALUES ('60', '53', '文章标题53', '文章内容53', null);
INSERT INTO `t_student_article` VALUES ('61', '54', '文章标题54', '文章内容54', null);
INSERT INTO `t_student_article` VALUES ('62', '55', '文章标题55', '文章内容55', null);
INSERT INTO `t_student_article` VALUES ('63', '56', '文章标题56', '文章内容56', null);
INSERT INTO `t_student_article` VALUES ('64', '57', '文章标题57', '文章内容57', null);
INSERT INTO `t_student_article` VALUES ('65', '58', '文章标题58', '文章内容58', null);
INSERT INTO `t_student_article` VALUES ('66', '59', '文章标题59', '文章内容59', null);
INSERT INTO `t_student_article` VALUES ('67', '60', '文章标题60', '文章内容60', null);
INSERT INTO `t_student_article` VALUES ('68', '61', '文章标题61', '文章内容61', null);
INSERT INTO `t_student_article` VALUES ('69', '62', '文章标题62', '文章内容62', null);
INSERT INTO `t_student_article` VALUES ('70', '63', '文章标题63', '文章内容63', null);
INSERT INTO `t_student_article` VALUES ('71', '64', '文章标题64', '文章内容64', null);
INSERT INTO `t_student_article` VALUES ('72', '65', '文章标题65', '文章内容65', null);
INSERT INTO `t_student_article` VALUES ('73', '66', '文章标题66', '文章内容66', null);
INSERT INTO `t_student_article` VALUES ('74', '67', '文章标题67', '文章内容67', null);
INSERT INTO `t_student_article` VALUES ('75', '68', '文章标题68', '文章内容68', null);
INSERT INTO `t_student_article` VALUES ('76', '69', '文章标题69', '文章内容69', null);
INSERT INTO `t_student_article` VALUES ('77', '70', '文章标题70', '文章内容70', null);
INSERT INTO `t_student_article` VALUES ('78', '71', '文章标题71', '文章内容71', null);
INSERT INTO `t_student_article` VALUES ('79', '72', '文章标题72', '文章内容72', null);
INSERT INTO `t_student_article` VALUES ('80', '73', '文章标题73', '文章内容73', null);
INSERT INTO `t_student_article` VALUES ('81', '74', '文章标题74', '文章内容74', null);
INSERT INTO `t_student_article` VALUES ('82', '75', '文章标题75', '文章内容75', null);
INSERT INTO `t_student_article` VALUES ('83', '76', '文章标题76', '文章内容76', null);
INSERT INTO `t_student_article` VALUES ('84', '77', '文章标题77', '文章内容77', null);
INSERT INTO `t_student_article` VALUES ('85', '78', '文章标题78', '文章内容78', null);
INSERT INTO `t_student_article` VALUES ('86', '79', '文章标题79', '文章内容79', null);
INSERT INTO `t_student_article` VALUES ('87', '80', '文章标题80', '文章内容80', null);
INSERT INTO `t_student_article` VALUES ('88', '81', '文章标题81', '文章内容81', null);
INSERT INTO `t_student_article` VALUES ('89', '82', '文章标题82', '文章内容82', null);
INSERT INTO `t_student_article` VALUES ('90', '83', '文章标题83', '文章内容83', null);
INSERT INTO `t_student_article` VALUES ('91', '84', '文章标题84', '文章内容84', null);
INSERT INTO `t_student_article` VALUES ('92', '85', '文章标题85', '文章内容85', null);
INSERT INTO `t_student_article` VALUES ('93', '86', '文章标题86', '文章内容86', null);
INSERT INTO `t_student_article` VALUES ('94', '87', '文章标题87', '文章内容87', null);
INSERT INTO `t_student_article` VALUES ('95', '88', '文章标题88', '文章内容88', null);
INSERT INTO `t_student_article` VALUES ('96', '89', '文章标题89', '文章内容89', null);
INSERT INTO `t_student_article` VALUES ('97', '90', '文章标题90', '文章内容90', null);
INSERT INTO `t_student_article` VALUES ('98', '91', '文章标题91', '文章内容91', null);
INSERT INTO `t_student_article` VALUES ('99', '92', '文章标题92', '文章内容92', null);
INSERT INTO `t_student_article` VALUES ('100', '93', '文章标题93', '文章内容93', null);
INSERT INTO `t_student_article` VALUES ('101', '94', '文章标题94', '文章内容94', null);
INSERT INTO `t_student_article` VALUES ('102', '95', '文章标题95', '文章内容95', null);
INSERT INTO `t_student_article` VALUES ('103', '96', '文章标题96', '文章内容96', null);
INSERT INTO `t_student_article` VALUES ('104', '97', '文章标题97', '文章内容97', null);
INSERT INTO `t_student_article` VALUES ('105', '98', '文章标题98', '文章内容98', null);
INSERT INTO `t_student_article` VALUES ('106', '99', '文章标题99', '文章内容99', null);
INSERT INTO `t_student_article` VALUES ('107', '100', '文章标题100', '文章内容100', null);
INSERT INTO `t_student_article` VALUES ('108', '1', '1', '                                                \r\n        1\r\n        \r\n        \r\n        ', '1513752685047back.png');
