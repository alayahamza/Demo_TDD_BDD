/*CREATE TABLE T_USER (
  ID           INTEGER   PRIMARY KEY  NOT NULL,
  NAME  VARCHAR(50)  NOT NULL,
  EMAIL VARCHAR(50));
 

CREATE TABLE T_ACCOUNT (
  ID           INTEGER   PRIMARY KEY  NOT NULL,
  BALANCE  INTEGER  NOT NULL,
  OWNER_ID INTEGER NOT NULL);

 ALTER TABLE "T_ACCOUNT" ADD CONSTRAINT "FK_T_ACCOUNT" FOREIGN KEY ("OWNER_ID")
	  REFERENCES "T_USER" ("ID")  ;
	 */ 
insert into T_USER(ID,NAME,EMAIL) values(1,'hamza','hamza.alaya@talan.tn');
insert into T_USER(ID,NAME,EMAIL) values(2,'madhi','mahdi.amri@talan.tn');
insert into T_USER(ID,NAME,EMAIL) values(3,'achraf','achraf.ben.atia@talan.tn');