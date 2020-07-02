conn system/123;
Connected.
create tablespace mraflif_06983
datafile 'D:\RAFLI\Tugas Kuliah\Semester 4\Praktikum\Basis Data\Modul 1\sistem_jual_toko_kelontong.dbf'
size 50m;

create user mraflif_06983
identified by rafli
default tablespace mraflif_06983
quota 50m on mraflif_06983;

grant all privileges to mraflif_06983;

create table Transaksi
(
ID_Transaksi integer not null,
Jumlah_Pembelian integer,
Total_Harga integer,
Bayar integer,
Kembali integer,
constraint PK_Transaksi primary key (ID_Transaksi)
);

create table Barang
(
ID_Barang integer not null,
ID_Jenis_Barang integer,
Nama_Barang varchar(20),
Harga integer,
Stock integer,
constraint PK_Barang primary key (ID_Barang)
);

create table Jenis_Barang
(
ID_Jenis_Barang integer not null,
Nama_Jenis_Barang varchar(15),
constraint PK_Jenis_Barang primary key (ID_Jenis_Barang)
);

alter table Barang
add constraint FK_ID_Jenis_Barang foreign key (ID_Jenis_Barang)
references Jenis_Barang(ID_Jenis_Barang);

create sequence ID_Barang
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 10;

create sequence ID_Transaksi
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 10;

create sequence ID_Jenis_Barang
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 10;

alter table Barang add constraint Barang_unique UNIQUE(Nama_Barang);

create table Detail_Pemesanan
(
ID_Transaksi integer,
ID_Barang integer,
Jumlah integer,
constraint FK_ID_Transaksi foreign key (ID_Transaksi)
references Transaksi(ID_Transaksi),
constraint FK_ID_Barang foreign key (ID_Barang)
references Barang(ID_Barang)
);

savepoint point1;

rollback to point1;

commit;

create view list_detail as
select a.nama_barang, a.harga, b.nama_jenis_barang
from Barang a join
jenis_barang b on
a.id_jenis_barang = b.id_jenis_barang
where rownum <= 10;

select * from list_detail;

select * from barang join jenis_barang on barang.id_jenis_barang = jenis_barang.id_jenis_barang;

create view list_detail2 as
select a.id_transaksi, b.id_barang, c.nama_barang
from Transaksi a left join Detail_Pemesanan b
on a.id_transaksi = b.id_transaksi
left join Barang c
on b.id_barang = c.id_barang
where a.id_transaksi >= (select count(id_transaksi) from Transaksi);

select * from list_detail2;

create view list_detail3 as
select a.id_transaksi, b.nama_barang, c.nama_jenis_barang, b.stock
from Detail_Pemesanan a right join Barang b
on a.id_barang = b.id_barang
right join Jenis_Barang c
on b.id_jenis_barang = c.id_jenis_barang
where a.id_transaksi >= (select count(id_transaksi) from Detail_Pemesanan)
or b.id_barang >= (select count(id_barang) from Barang);

select * from list_detail3;

commit;