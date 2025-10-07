USE note_application;

DROP TABLE IF EXISTS note_details;
DROP TABLE IF EXISTS note;

CREATE TABLE note_details(
	ids int NOT NULL AUTO_INCREMENT,
    username_reference VARCHAR(10),
    note_importnace VARCHAR(20) NOT NULL,
    note_date VARCHAR(20),
    PRIMARY KEY (ids)
) ENGINE=InnoDB CHARSET=latin1;

CREATE TABLE note(
	id int NOT NULL AUTO_INCREMENT,
    note_body VARCHAR(1000),
    note_detail_id int DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (note_detail_id) REFERENCES note_details (ids) ON DELETE CASCADE
) ENGINE=InnoDB CHARSET=latin1;