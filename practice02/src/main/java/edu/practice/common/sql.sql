SELECT /*+ INDEX_DESC(t_board t_board_pk) */ 
	   rownum rn, bno, title, content	
FROM T_BOARD
WHERE bno > 0


CREATE TABLE t_reply(
	rno NUMBER(10, 0),
	bno NUMBER(10, 0) NOT NULL,
	reply varchar2(1000) NOT NULL,
	replyer varchar2(50) NOT NULL,
	replyDate DATE DEFAULT sysdate,
	updateDate DATE DEFAULT sysdate
)

CREATE SEQUENCE seq_t_reply

ALTER TABLE t_reply ADD CONSTRAINT t_reply_pk PRIMARY KEY(rno)

ALTER TABLE t_reply ADD CONSTRAINT t_reply_board_fk
FOREIGN KEY (bno) REFERENCES t_board(bno)