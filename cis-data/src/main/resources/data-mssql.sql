/* Create default years */
SET IDENTITY_INSERT academic_year ON;
INSERT INTO academic_year (id, code, description, start_date, end_date) VALUES (1, '11/12', '2011/12', '2011-08-30', '2012-07-31');
INSERT INTO academic_year (id, code, description, start_date, end_date) VALUES (2, '12/13', '2012/13', '2012-08-30', '2013-07-31');
INSERT INTO academic_year (id, code, description, start_date, end_date) VALUES (3, '13/14', '2013/14', '2013-08-30', '2014-07-31');
INSERT INTO academic_year (id, code, description, start_date, end_date) VALUES (4, '14/15', '2014/15', '2014-08-30', '2015-07-31');
INSERT INTO academic_year (id, code, description, start_date, end_date) VALUES (5, '15/16', '2015/16', '2015-08-30', '2016-07-31');
SET IDENTITY_INSERT academic_year OFF

/* Creating School Types */ 
SET IDENTITY_INSERT school_type ON;
INSERT INTO school_type (id, code, description) VALUES (1, 'PS', 'Partner School');
INSERT INTO school_type (id, code, description) VALUES (2, 'C', 'County School');
INSERT INTO school_type (id, code, description) VALUES (3, 'I', 'Independent School');
SET IDENTITY_INSERT school_type OFF;


/* Creating School Data */
SET IDENTITY_INSERT school ON;
INSERT INTO school (id, name, type_id) VALUES (1, 'Oakwood', 1);
INSERT INTO school (id, name, type_id) VALUES (2, 'Reigate School', 1);
INSERT INTO school (id, name, type_id) VALUES (3, 'DeStafford', 1);
INSERT INTO school (id, name, type_id) VALUES (4, 'Warwick', 1);
SET IDENTITY_INSERT school OFF;


/* Create defualt genders */
SET IDENTITY_INSERT gender ON;
INSERT INTO gender (id, code, description) VALUES (1, 'M', 'Male');
INSERT INTO gender (id, code, description) VALUES (2, 'F', 'Female');
SET IDENTITY_INSERT gender OFF;

/* Create Offer Types*/
SET IDENTITY_INSERT offer_type ON;
INSERT INTO offer_type (id, code, description) VALUES (1, '-', 'Offer Pending');
INSERT INTO offer_type (id, code, description) VALUES (2, 'U', 'Unconditional Offer');
INSERT INTO offer_type (id, code, description) VALUES (3, 'P', 'Provisional Offer');
INSERT INTO offer_type (id, code, description) VALUES (4, 'X', 'Rejection');
SET IDENTITY_INSERT offer_type OFF;

/* Create default Blocks */
SET IDENTITY_INSERT block ON;
INSERT INTO block (id, code, description) VALUES (1, '1', 'Block 1');
INSERT INTO block (id, code, description) VALUES (2, '2', 'Block 2');
INSERT INTO block (id, code, description) VALUES (3, '3', 'Block 3');
INSERT INTO block (id, code, description) VALUES (4, '4', 'Block 4');
INSERT INTO block (id, code, description) VALUES (5, '5', 'Block 5');
INSERT INTO block (id, code, description) VALUES (6, '6', 'Block 6');
INSERT INTO block (id, code, description) VALUES (7, '7', 'Block 7');
SET IDENTITY_INSERT block OFF;


/* Create default Periods */
SET IDENTITY_INSERT period ON;
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (1, 'Mon01', 'Monday Period 1', 1, 1, '09:00:00', '10:05:00', 1);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (2, 'Mon02', 'Monday Period 2', 1, 2, '09:00:00', '10:05:00', 2);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (3, 'Mon03', 'Monday Period 3', 1, 3, '09:00:00', '10:05:00', 3);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (4, 'Mon04', 'Monday Period 4', 1, 4, '09:00:00', '10:05:00', 4);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (5, 'Mon05', 'Monday Period 5', 1, 5, '09:00:00', '10:05:00', 5);

INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (6, 'Tue01', 'Tuesday Period 1', 2, 1, '09:00:00', '10:05:00', 2);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (7, 'Tue02', 'Tuesday Period 2', 2, 2, '09:00:00', '10:05:00', 3);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (8, 'Tue03', 'Tuesday Period 3', 2, 3, '09:00:00', '10:05:00', 4);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (9, 'Tue04', 'Tuesday Period 4', 2, 4, '09:00:00', '10:05:00', 5);
INSERT INTO period (id, code, description, day, day_period, start_time, end_time, block_id) VALUES (10, 'Tue05', 'Tuesday Period 5', 2, 5, '09:00:00', '10:05:00', 6);
SET IDENTITY_INSERT period OFF;

/* Create default Titles */
SET IDENTITY_INSERT title ON;
INSERT INTO title (id, code, description) VALUES (1, '1', 'Mr');
INSERT INTO title (id, code, description) VALUES (2, '2', 'Mrs');
INSERT INTO title (id, code, description) VALUES (3, '3', 'Miss');
INSERT INTO title (id, code, description) VALUES (4, '4', 'Ms');
INSERT INTO title (id, code, description) VALUES (5, '5', 'Dr');
INSERT INTO title (id, code, description) VALUES (6, '6', 'Rev');
INSERT INTO title (id, code, description) VALUES (7, '7', 'Sir');
INSERT INTO title (id, code, description) VALUES (8, '8', 'Lady');
INSERT INTO title (id, code, description) VALUES (9, '9', 'Lord');
INSERT INTO title (id, code, description) VALUES (10, '10', 'Dame');
INSERT INTO title (id, code, description) VALUES (11, '11', 'Prof');
INSERT INTO title (id, code, description) VALUES (12, '12', 'Capt');
INSERT INTO title (id, code, description) VALUES (98, '98', 'None');
INSERT INTO title (id, code, description) VALUES (99, '99', 'Other');
SET IDENTITY_INSERT title OFF;

/* Create default Application Statuses */
SET IDENTITY_INSERT application_status ON;
INSERT INTO application_status (id, code, description) VALUES (1, 'N', 'New');
INSERT INTO application_status (id, code, description) VALUES (2, 'R', 'Recieved');
INSERT INTO application_status (id, code, description) VALUES (3, 'C', 'Checked');
INSERT INTO application_status (id, code, description) VALUES (4, 'A', 'Accepted');
INSERT INTO application_status (id, code, description) VALUES (5, 'X', 'Rejected');
SET IDENTITY_INSERT application_status OFF;

/* Create default Contact Types */ 
SET IDENTITY_INSERT contact_type ON;
INSERT INTO contact_type (id, description, name) VALUES ('1', 'Father', 'Father');
INSERT INTO contact_type (id, description, name) VALUES ('2', 'Mother', 'Mother');
INSERT INTO contact_type (id, description, name) VALUES ('3', 'Gaurdian', 'Guardian');
SET IDENTITY_INSERT contact_type OFF;

/* Create default Nationality data*/
SET IDENTITY_INSERT nationality ON;
INSERT INTO nationality (id, description, name) VALUES ('1', 'English', 'Eng');
INSERT INTO nationality (id, description, name) VALUES ('2', 'Other', 'Oth');
SET IDENTITY_INSERT nationality OFF;

/* Create default Disability data*/
SET IDENTITY_INSERT disability ON;
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (1, '1', 'Visual impairment', 'VI', 1, null);
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (2, '2', 'Hearing impairment', 'HI', 1, null);
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (3, '3', 'Disability affecting mobility', 'MOB', 1, null);
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (4, '4', 'Other physical disability', 'OPD', 1, null);
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (5, '5', 'Other medical condition', 'OMC', 1, null);
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (97, '97', 'Other', 'OTH', 1, null);
INSERT INTO disability (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (99, '99', 'Not known/not provided', 'NK', 1, null);
SET IDENTITY_INSERT disability OFF;

/* Create default Learning Difficulty data*/
SET IDENTITY_INSERT learning_difficulty ON;
INSERT INTO learning_difficulty (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (1, '1', 'Moderate learning difficulty', 'MOD', 1, null);
INSERT INTO learning_difficulty (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (2, '2', 'Servere learning difficulty', 'SER', 1, null);
INSERT INTO learning_difficulty (id, code,description,short_description,valid_from_id,valid_to_id) VALUES (99, '99', 'Other', 'OTH', 1, null);
SET IDENTITY_INSERT learning_difficulty OFF;

/* Create default Student Types */ 
SET IDENTITY_INSERT student_type ON;
INSERT INTO student_type (id, description, code) VALUES ('1', 'Lower', 'L');
INSERT INTO student_type (id, description, code) VALUES ('2', 'Upper', 'U');
INSERT INTO student_type (id, description, code) VALUES ('3', 'Intermediate', 'I');
SET IDENTITY_INSERT student_type OFF;

/* Create default Faculties */
SET IDENTITY_INSERT faculty ON;
INSERT INTO faculty (id, description, name) VALUES ('1', 'Science and Art', 'SA');
INSERT INTO faculty (id, description, name) VALUES ('2', 'Maths and Media', 'MM');
INSERT INTO faculty (id, description, name) VALUES ('3', 'Other', 'Other');
SET IDENTITY_INSERT faculty OFF;

/* Create default Departments */
SET IDENTITY_INSERT department ON;
INSERT INTO department (id, description, name, faculty_id) VALUES ('1', 'Science', 'Science', 1);
INSERT INTO department (id, description, name, faculty_id) VALUES ('2', 'Art', 'Art', 1);
INSERT INTO department (id, description, name, faculty_id) VALUES ('3', 'Math', 'Maths', 2);
INSERT INTO department (id, description, name, faculty_id) VALUES ('4', 'Media', 'Media', 2);
INSERT INTO department (id, description, name, faculty_id) VALUES ('5', 'Leaning Support', 'Leaning Support', 3);
SET IDENTITY_INSERT department OFF;


/* Create default Tutor Group */ 
SET IDENTITY_INSERT tutor_group ON;
INSERT INTO tutor_group (id, description, code) VALUES ('1', 'A01', 'A01');
INSERT INTO tutor_group (id, description, code) VALUES ('2', 'A02', 'A02');
INSERT INTO tutor_group (id, description, code) VALUES ('3', 'A03', 'A03');
SET IDENTITY_INSERT tutor_group OFF;




/* Create default settings */
SET IDENTITY_INSERT setting ON;
INSERT INTO setting (id, setting, value) VALUES (1, 'CollegeName', 'Reigate College');
INSERT INTO setting (id, setting, value) VALUES (2, 'CurrentYearCode', '14/15');
INSERT INTO setting (id, setting, value) VALUES (3, 'NextYearCode', '15/16');
SET IDENTITY_INSERT setting OFF;




/* Create sample Application data */
SET IDENTITY_INSERT address ON;
INSERT INTO address (id, paon, postcode) VALUES (1, '87', 'RH6 8BZ');
INSERT INTO address (id, paon, postcode) VALUES (2, 'Some Island', 'TS1 1SI');
SET IDENTITY_INSERT address OFF;

SET IDENTITY_INSERT person ON;
INSERT INTO person (id, surname, first_name, dob, gender_id, address_id) VALUES (1, 'Horgan', 'Michael', '1980-07-06', 1, 1);
INSERT INTO person (id, title_id, surname, first_name) VALUES (2, 1, 'Horgan', 'Gerald');
INSERT INTO person (id, title_id, surname, first_name) VALUES (3, 2, 'Horgan', 'Sandra');
INSERT INTO person (id, surname, first_name, dob, gender_id, address_id) VALUES (4, 'Stark', 'Tony', '1975-01-02', 1, 2);
INSERT INTO person (id, title_id, surname, first_name) VALUES (5, 1, 'Stark', 'Frank');
SET IDENTITY_INSERT person OFF;

SET IDENTITY_INSERT application ON;
INSERT INTO application (id, received, reference_no, person_id, school_id) VALUES (1, '2015-06-01','14-999', 1, 1);
INSERT INTO application (id, received, reference_no, person_id, school_id) VALUES (2, '2015-06-01','14-998', 4, 3);
SET IDENTITY_INSERT application OFF;

SET IDENTITY_INSERT contact ON;
INSERT INTO contact (id, person_id, contact_id, contact_type_id, contactable, preferred) VALUES (1, 1, 2, 1, 1, 1);
INSERT INTO contact (id, person_id, contact_id, contact_type_id, contactable, preferred) VALUES (2, 1, 3, 2, 1, 1);
INSERT INTO contact (id, person_id, contact_id, contact_type_id, contactable, preferred) VALUES (3, 4, 5, 1, 1, 1);
SET IDENTITY_INSERT contact OFF;


