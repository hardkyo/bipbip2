
-- map ���̺� ���� ����
create table map
(
loc1X number(20,15) not null,
loc1Y number(20,15) not null,
loc2X number(20,15) not null,
loc2Y number(20,15) not null,
sec1X number(20,15),
sec1Y number(20,15),
sec2X number(20,15),
sec2Y number(20,15),
sec3X number(20,15),
sec3Y number(20,15),
loc1 varchar2(50),
loc2 varchar2(50),
sec1 varchar2(50),
sec2 varchar2(50),
sec3 varchar2(50),
memo varchar2(500),
mapHit number(10)
);
 -- �μ�Ʈ ����
insert
into map(loc1X,loc1Y,loc2X,loc2Y,
sec1X,sec1Y,sec2X,sec2Y,sec3X,sec3Y,
loc1,loc2,sec1,sec2,sec3,
memo, maphit)
values (?,?,?,?,
?,?,?,?,?,?,
?,?,?,?,?,
?, 0);

	-- ���� ������ �μ�Ʈ
	
insert
into map(loc1X,loc1Y,loc2X,loc2Y,
sec1X,sec1Y,sec2X,sec2Y,sec3X,sec3Y,
loc1,loc2,sec1,sec2,sec3,
memo, maphit)
values (415.418746494,148.18763496464,78.41846419415,874.1854646519641,
49.415169416,85.1854167218,274.524196106851,85.158464851569,18.15816465196,49.185912968412,
'�ձٲ��������̴�','������','���ƾƾ��̰ǹ���','�ֵ��ȵſ�','��Ű��¥����',
'�ð�����ǳ���ְ��', 0);



insert
into map(loc1X,loc1Y,loc2X,loc2Y,
sec1X,sec1Y,sec2X,sec2Y,sec3X,sec3Y,
loc1,loc2,sec1,sec2,sec3,
memo, maphit)
values (13.184654,3.58464846,549.415861,23.15646215,
13.546854,785.54651997,156.4874654312,784.1587654651,1597.15694654564156,15.153548,
'����� �߱� ���˿�','�׷��� �̷���','�ƹ����̳�','�������������','īī�̶���īī��',
'�̰��� ���̵����� 1��', 0);



insert
into map(loc1X,loc1Y,loc2X,loc2Y,
sec1X,sec1Y,sec2X,sec2Y,sec3X,sec3Y,
loc1,loc2,sec1,sec2,sec3,
memo, maphit)
values (45.498465413,53.5784941616,487.45746111,639.54649841348,
48.48764964,789.48464316,54.48746161,54.678491616,489.1587463481,418.1857464197454,
'�λ��� ¯�̴�','���� �׷���','�����׷����ްŰ��','�̰� ��¥ ���ƶ���η�','��� �����ٴٴپƾ�',
'�ʰ� �׷��� �ο��� ���ش±���', 0);

			----------------------------------------

 -- select TEST
 

select
loc1,loc2,sec1,sec2,sec3,
maphit
from map


 -- alter table query

alter table map
    add
    
   ( loc1 VARCHAR2(500),
    
    loc2 VARCHAR2(500),
    
    sec1 VARCHAR2(500),
    
    sec2 VARCHAR2(500),
    
    sec3 VARCHAR2(500))