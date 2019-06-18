CREATE TABLE tbl_reply (
	rno number(10,0),
	bno number(10,0) NOT NULL,
	reply varchar2(1000) NOT NULL,
	replyer varchar2(50) NOT NULL,
	replyDate DATE DEFAULT SYSDATE,
	updateDate DATE DEFAULT SYSDATE
)

CREATE SEQUENCE seq_reply

ALTER TABLE tbl_reply ADD CONSTRAINT pk_reply PRIMARY KEY (rno)

ALTER TABLE TBL_REPLY ADD CONSTRAINT fk_reply_board
FOREIGN KEY (bno) REFERENCES TBL_BOARD (bno)

CREATE INDEX idx_reply ON tbl_reply (bno DESC, rno asc)