INSERT INTO KATEGORI
  ( id, nama)
VALUES
  ( 1, 'HOME'),
  ( 2, 'FASHION'),
  ( 3, 'BEAUTY'),
  ( 4, 'ELECTRONIC');

/*INSERT INTO BATCH
    (id_Batch, waktu_Mulai, waktu_Selesai, batas_Kirim)
VALUES
    (1, '08:00:00', '15:00:00', 750),
    (2, '15:00:01', '22:00:00', 500),
    (3, '22:00:01', '07:59:00', 300);
*/
INSERT INTO KERANJANG VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(22),
(15),
(99);

INSERT INTO PEMBELI (id,idWallet,kota,nama,nohp,id_keranjang) VALUES
(1,1,'semarang','Dito A','08xxx',1),
(2,2,'tegal','Adji P','08xxx',2),
(4,4,'jaktim','Yuvens B','08xxx',4),
(6,6,'jogja','Ulfa I','08xxx',6),
(9,9,'padang','Ridwan S','08xxx',9),
(10,10,'aceh','Ria F','08xxx',10),
(22,22,'merauke','E. Wardhani','08xxx',22),
(15,15,'jaksel','Aku Siapa?','08xxx',15),
(99,99,'jakut','Aku Siapa ya?','08xxx',99);

INSERT INTO PENJUAL VALUES
(1, 'Jakarta','Adjie', 335000),
(4, 'Bandung','AdjieW', 345000);

INSERT INTO master_blacklist VALUES
(1, 'kriminal', 2),
(2, 'id tidak valid',4),
(3, 'terindikasi pencurian',6),
(4, 'mantan koruptor',9),
(5, 'terindikasi pencurian',10),
(6, 'terindikasi kecurangan',22),
(7, 'terindikasi pencucian',15);

INSERT INTO payment_channel VALUES
(1, 'VA'),
(2, 'CC'),
(3, 'Wallets'),
(4, 'ConvinienceStore');

INSERT INTO Wallet VALUES
(1, 'DOKU'),
(2, 'CocoPay');

INSERT INTO account VALUES
(1,'herman',100000),
(2,'rahmat',150000),
(3,'lila',50000),
(4,'alamin',1000),
(99,'E-Commerce',0);


insert into barang values
(1,1,10000,'guling',5,4,4),
(2,1,12000,'bantal',5,4,4);

INSERT into keranjangdetail values
(1,10000,1,1,1,1);

INSERT into batch values
(1, 100, '08:00:00', '15:00:00');

INSERT into transaksi values
(1, 200000.0, 20, 1, '2020-01-09', 1);