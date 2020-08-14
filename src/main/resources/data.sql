
--status
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('1', 'APPLIED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('2', 'PROCESSING');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('3', 'APPROVED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('4', 'SANCTIONED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('5', 'RESOLVED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('6', 'SUCCESS');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('7', 'REJECTED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('8', 'FAILED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('9', 'REFUNDED');
INSERT INTO `bankapplication`.`status` (`id`, `name`) VALUES ('10', 'RAISED');
--Rowstatus
INSERT INTO `bankapplication`.`row_status` (`id`, `name`) VALUES ('1', 'ACTIVE');
INSERT INTO `bankapplication`.`row_status` (`id`, `name`) VALUES ('2', 'INACTIVE');
INSERT INTO `bankapplication`.`row_status` (`id`, `name`) VALUES ('3', 'DELETED');

--Roles
INSERT INTO `bankapplication`.`role` (`id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `bankapplication`.`role` (`id`, `name`) VALUES ('2', 'MANAGER');
INSERT INTO `bankapplication`.`role` (`id`, `name`) VALUES ('3', 'EMPLOYEE');

--eligibility
INSERT INTO `bankapplication`.`eligibility` (`id`, `max_age`, `min_age`) VALUES ('1', '110', '15');
INSERT INTO `bankapplication`.`eligibility` (`id`, `max_age`, `min_age`) VALUES ('2', '60', '19');

--accountTypes
INSERT INTO `bankapplication`.`account_type` (`id`, `interest`, `min_balance`, `name`, `transaction_limit`, `withdraw_limit`, `eligibility_id`) VALUES ('1', '6', '500', 'SAVINGS', '5', '50000', '1');
INSERT INTO `bankapplication`.`account_type` (`id`, `interest`, `min_balance`, `name`, `transaction_limit`,`withdraw_limit`, `eligibility_id`) VALUES ('2', '0', '5000', 'CURRENT', '0', '0', '1');

--loantypes
INSERT INTO `bankapplication`.`loan_type` (`id`, `interest`, `max_amount`, `min_amount`, `months`, `name`, `account_type_id`, `eligibility_id`, `row_status_id`) VALUES ('1', '1', '1000000', '300000', '36', 'HOME', '1', '2', '1');
INSERT INTO `bankapplication`.`loan_type` (`id`, `interest`, `max_amount`, `min_amount`, `months`, `name`,
`account_type_id`, `eligibility_id`, `row_status_id`) VALUES ('2', '1', '1000000', '300000', '36', 'HOME', '1', '2', '1');
INSERT INTO `bankapplication`.`loan_type` (`id`, `interest`, `max_amount`, `min_amount`, `months`, `name`,`account_type_id`, `eligibility_id`, `row_status_id`) VALUES ('3', '1', '1500000', '300000', '60', 'FOUR_WHEELER', '1','2','1');
INSERT INTO `bankapplication`.`loan_type` (`id`, `interest`, `max_amount`, `min_amount`, `months`, `name`,
`account_type_id`, `eligibility_id`, `row_status_id`) VALUES ('4', '1', '1500000', '300000', '60', 'FOUR_WHEELER', '1','2','1');
INSERT INTO `bankapplication`.`loan_type` (`id`, `interest`, `max_amount`, `min_amount`, `months`, `name`,`account_type_id`, `eligibility_id`, `row_status_id`) VALUES ('5', '1', '300000', '50000', '24', 'TWO_WHEELER', '1','2','1');
INSERT INTO `bankapplication`.`loan_type` (`id`, `interest`, `max_amount`, `min_amount`, `months`, `name`,
`account_type_id`, `eligibility_id`, `row_status_id`) VALUES ('6', '1', '300000', '50000', '24', 'TWO_WHEELER', '1','2','1');




