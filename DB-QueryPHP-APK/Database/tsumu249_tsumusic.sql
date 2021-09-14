-- MariaDB dump 10.19  Distrib 10.4.19-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: tsumu249_tsumusic
-- ------------------------------------------------------
-- Server version	10.3.29-MariaDB-cll-lve

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `MATHANHVIEN` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `url_image` text COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MATHANHVIEN`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (111,'7','7','94edf28c6d6da38fd35d7ad53e485307f89fbeaf120485c8d17a43f323deee71','snghoang9@gmail.com',NULL),(116,'quang vũ','quang vũ','10aae199e6a263bf528bc671d1f267aca6630eb273d7440bd3ddd7767f0ce934','qv10@gmail.com',NULL),(118,'Minh Trường','mt1','10aae199e6a263bf528bc671d1f267aca6630eb273d7440bd3ddd7767f0ce934','mtruong','https://res.cloudinary.com/van-nam/image/upload/v1624027611/resource/184562951_480620346504509_8951031304534479801_n_peaptp.jpg'),(119,'van nam','vn2','987b64342dbf91505b6bd8afdec75b0bf8b1e4c9fdd0f37c02a60f4d2e5d09d1','vnamnguyenn@gmail.com',NULL),(120,'Nguyễn Văn Nam','vn13012000','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','vn13012000@gmail.com',NULL);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `MAALBUM` int(11) NOT NULL AUTO_INCREMENT,
  `TENALBUM` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MACASI` int(11) NOT NULL,
  `URLALBUM` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MAALBUM`),
  KEY `MACASI` (`MACASI`),
  CONSTRAINT `album_ibfk_1` FOREIGN KEY (`MACASI`) REFERENCES `casi` (`MACASI`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'NCS',65,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg'),(24,'Tuyển tập Sleeping Lion',55,'https://res.cloudinary.com/van-nam/image/upload/v1623480652/Image/Album/71Dw92nDgVL._SS500__fo1uds.jpg'),(25,'Made',4,'https://res.cloudinary.com/van-nam/image/upload/v1621420687/Image/Album/made_npxszi.jpg'),(26,'Tuyển chọn Ella Joy Meir',4,'https://res.cloudinary.com/van-nam/image/upload/v1623479623/Image/Album/21556_101238326573162_7094453_n_cxsodf.jpg'),(27,'Những bài hát hay nhất của Elektronomia',58,'https://res.cloudinary.com/van-nam/image/upload/v1623478304/Image/Album/elektronomia_kuiigj.jpg'),(30,'Tuyển top Charlie Peacock',56,'https://res.cloudinary.com/van-nam/image/upload/v1623481407/Image/Album/CAEQAxokYjFlN2NkZmEvZjJmNC80NDUwL2FjNjcvMWQ4MmFjNThmNjM1GiQ0ZmExNjkyNS9mNzdjLzQ1MWMvOGM1NC82YzUwZTcxYjRkMWYaJDViZWI1Yjg3Lzk0YTYvNGI1NS85ZTY2LzM5NzJmMTY1ZmY3ZiIKV3JpdHRlbiBCeSIPQ2hhcmxpZSBQZWFjb2NrKgcjRjJDQTYxMAE_kkvmsx.jpg'),(31,'Young',59,'https://res.cloudinary.com/van-nam/image/upload/v1623481968/Image/Album/ab67616d0000b27379bd6c032ce316d766f4f618_tudyg9.jpg'),(32,'Những bài hát hay nhất của Tobu',61,'https://res.cloudinary.com/van-nam/image/upload/v1623481846/Image/Album/tobu_eleimz.jpg\r\n'),(33,'Những bài hát hay nhất của Jim Yosef',62,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg'),(34,'Những bài hát hay nhất của Lostsky',63,'https://res.cloudinary.com/van-nam/image/upload/v1623479907/Image/Album/lostsky_s5oryq.jpg'),(35,'HipHop Jumbo',64,'https://res.cloudinary.com/van-nam/image/upload/v1623484252/Image/Album/maxresdefault_lj9yo7.jpg'),(36,'Vol 1',57,'https://res.cloudinary.com/van-nam/image/upload/v1623477485/Image/Album/album_c7h4m1.jpg'),(37,'NCS: Infinity',65,'https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg'),(38,'Tuyển Tập Trap 2021',66,'https://res.cloudinary.com/van-nam/image/upload/v1623488113/Image/Album/images_m87go7.jpg'),(39,'NCS: The Best of 2016',65,'https://res.cloudinary.com/van-nam/image/upload/v1623489158/Image/Playlist/NCS:%20The%20Best%20of%202016/ncs_2016_4000_wlwwc2.jpg'),(40,'NCS: Colors',65,'https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg'),(42,'R&B best 2021',66,'https://res.cloudinary.com/van-nam/image/upload/v1623489026/Image/Album/0711574902910_shkfjq.jpg'),(47,'NCS: The Best of 2017',65,'https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg'),(49,'NCS: Alpha',65,'https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg'),(50,'NCS: Reloaded',65,'https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg'),(53,'Những bài hát hay nhất của Cartoon',60,'https://res.cloudinary.com/van-nam/image/upload/v1623480878/Image/Album/cartoon_vctyij.jpg'),(55,'Những bài hát hay của Erik',68,'https://res.cloudinary.com/van-nam/image/upload/v1626100693/resource/erik1_xf3hks.jpg');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baihat`
--

DROP TABLE IF EXISTS `baihat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baihat` (
  `MABAIHAT` int(11) NOT NULL AUTO_INCREMENT,
  `TENBAIHAT` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MATHELOAI` int(11) NOT NULL,
  `MIEUTA` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `LOIBAIHAT` varchar(4000) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `URLBAIHAT` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `LUOTNGHE` bigint(20) NOT NULL,
  `URLHINHBAIHAT` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MANHACSI` int(11) NOT NULL,
  `MAALBUM` int(11) DEFAULT NULL,
  `NGAYPHATHANH` datetime NOT NULL,
  `TIMEUPDATE` datetime DEFAULT NULL,
  `MATOPLIST` int(11) DEFAULT NULL,
  PRIMARY KEY (`MABAIHAT`),
  KEY `MATHELOAI` (`MATHELOAI`),
  KEY `MANHACSI` (`MANHACSI`),
  KEY `MAALBUM` (`MAALBUM`),
  KEY `MATOPLIST` (`MATOPLIST`),
  CONSTRAINT `baihat_ibfk_6` FOREIGN KEY (`MATHELOAI`) REFERENCES `theloai` (`MATHELOAI`),
  CONSTRAINT `baihat_ibfk_7` FOREIGN KEY (`MAALBUM`) REFERENCES `album` (`MAALBUM`),
  CONSTRAINT `baihat_ibfk_8` FOREIGN KEY (`MANHACSI`) REFERENCES `nhacsi` (`MANHACSI`),
  CONSTRAINT `baihat_ibfk_9` FOREIGN KEY (`MATOPLIST`) REFERENCES `toplist` (`MATOPLIST`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baihat`
--

LOCK TABLES `baihat` WRITE;
/*!40000 ALTER TABLE `baihat` DISABLE KEYS */;
INSERT INTO `baihat` VALUES (6,'Ripple Effect (feat. J.Kendall)',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623414981/Music/Ripple-Effect-feat.-J.Kendall_trzvoq.wav',15,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00','2021-06-21 21:57:13',NULL),(8,'Come Out',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623422334/Music/Come-Out_wmyhaf.wav',20,'https://res.cloudinary.com/van-nam/image/upload/v1623422342/Image/Singer/77379272_10157073050697362_9219561284171726848_n_nxo7yy.jpg',2,1,'2011-00-00 00:00:00','2021-06-20 21:21:18',NULL),(21,'Who\'s That Girl',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623423491/Music/Whos-That-Girl_t3f8vp.wav',2,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00','2021-06-12 11:37:15',NULL),(22,'Freesias In The Afternoon',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623427974/Music/Freesias-In-The-Afternoon_qe7ngt.wav',2,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00','2021-06-18 22:34:47',NULL),(23,'Drip',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623437264/Music/Drip_fvhrjq.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00',NULL,NULL),(24,'Dreamland',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623427812/Music/Dreamland_veppkn.wav',5,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00','2021-06-19 13:26:46',NULL),(25,'Skydiving',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623427683/Music/Skydiving_sukqts.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(26,'Yesterday I Was A Bird',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623427600/Music/Yesterday-I-Was-A-Bird_yfzuzq.wav',2,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00','2021-06-12 08:38:23',NULL),(27,'Psalm',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623427500/Music/Psalm_b62cvg.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(28,'Samplicity',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623427392/Music/Samplicity_b0pdwc.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(29,'Mason Jar',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623398684/Music/Mason-Jar_fpya1l.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00',NULL,NULL),(30,'Nebula',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623438200/Music/Nebula_sy6clb.wav',3,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00','2021-06-15 23:44:40',NULL),(31,'Daybreak',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623438286/Music/Daybreak_kombce.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00','2021-06-15 18:29:27',NULL),(32,'Tumbleweed',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623438460/Music/Tumbleweed_lpecz0.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00',NULL,NULL),(33,'Sleepwalking',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623438370/Music/Sleepwalking_qkc5z7.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00',NULL,NULL),(34,'Kaleidoscope',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623438567/Music/Kaleidoscope_hjtt8d.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(35,'Hollow',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439088/Music/Hollow_lmy09r.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,25,'0000-00-00 00:00:00','2021-06-15 21:07:16',NULL),(36,'The Optimist',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439168/Music/The-Optimist_q1g1ma.wav',3,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00','2021-06-16 01:26:17',NULL),(37,'Ageless',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439281/Music/Ageless_yp1eeb.wav',7,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00','2021-06-18 16:22:38',NULL),(38,'Long Long Day',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439406/Music/Long-Long-Day_jmdxq3.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(39,'Don’t Listen',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439479/Music/Dont-Listen_dbyhzy.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(40,'Sunset',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439592/Music/Sunset_divnpw.wav',0,'https://res.cloudinary.com/van-nam/video/upload/v1623439592/Music/Sunset_divnpw.wav',2,26,'0000-00-00 00:00:00',NULL,NULL),(41,'Construction',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439729/Music/Construction_cy7tji.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00','2021-06-16 21:28:20',NULL),(42,'Trivia',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623439886/Music/Trivia_t28ski.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(43,'Plus One',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440043/Music/Plus-One_dsz3s0.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,26,'0000-00-00 00:00:00',NULL,NULL),(44,'Something Happens',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444105/Music/Something-Happens_hvyfzy_aierrn.wav',14,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00','2021-06-19 02:26:22',NULL),(45,'With The Wind',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440268/Music/With-The-Wind_hsb7vq.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00',NULL,NULL),(46,'Breakfast',19,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440408/Music/Breakfast_wxraao.wav',17,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00','2021-06-16 22:38:19',NULL),(47,'Instincts',19,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440526/Music/Instincts_rgihwb.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00',NULL,NULL),(48,'Schedule',19,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440677/Music/Schedule_ncgrgd.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00',NULL,NULL),(49,'For Sure',19,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440766/Music/For-Sure_a0tdyq.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00',NULL,NULL),(50,'Boxed Up',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623440899/Music/Boxed-Up_xwvn4f.wav',35,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00','2021-06-18 01:35:07',NULL),(51,'Happy And Free',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623441987/Music/Happy-And-Free-feat.-Lex-Kuhl_ev0uqp.wav',5,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00','2021-06-18 11:23:17',NULL),(52,'Honey Bee',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623442149/Music/Honey-Bee-feat.-Jody-Nardone-Matt-Endahl_vcdcjs.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00',NULL,NULL),(53,'Country Girl City Dreams',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623442342/Music/Country-Girl-City-Dreams_egpdy9.wav',2,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00','2021-06-15 16:20:29',NULL),(54,'Carousel',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623442545/Music/Carousel_a7gfhg.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00',NULL,NULL),(55,'That Feels Right',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623442814/Music/That-Feels-Right-feat.-Sam-Ashworth_nvmabe.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00','2021-06-16 00:46:04',NULL),(56,'Sunshine',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623443034/Music/Sunshine-feat.-Ben-van-Maarth_vthven.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00','2021-06-16 00:33:06',NULL),(57,'Flower In Bloom',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623443217/Music/Flower-In-Bloom-feat.-Abigail-Flowers_u0fhbv.wav',2,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00','2021-06-16 21:36:02',NULL),(58,'Door of Your Heart',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623443507/Music/Door-of-Your-Heart_rnpo8f.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00','2021-06-16 21:32:04',NULL),(59,'New Day ',21,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623443716/Music/New-Day-feat.-Grant-Parker_o6s7ka.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00',NULL,NULL),(60,'Rainbow Motherfunk',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623443966/Music/Rainbow-Motherfunk-Instrumental_mufota.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,30,'0000-00-00 00:00:00',NULL,NULL),(61,'Something Happens',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444105/Music/Something-Happens_hvyfzy_aierrn.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,24,'0000-00-00 00:00:00',NULL,NULL),(62,'Lost In Thoughts',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444257/Music/Lost-In-Thoughts_nf45ki.wav',3,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00','2021-06-17 01:21:40',NULL),(63,'Views',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444399/Music/Views_n46zbh.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(64,'Primavera',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444603/Music/Primavera_hgunji.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(65,'Thinking By Myself',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444794/Music/Thinking-By-Myself_mcnu0m.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(66,'Click',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623444984/Music/Click_prlokh.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00','2021-06-16 22:41:32',NULL),(67,'Young',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623445171/Music/Young_uns8xd.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(68,'Used To Be',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623445337/Music/Used-To-Be_igrcdq.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(69,'Insane',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623445483/Music/Insane_hknrye.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(70,'Lalala',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623445657/Music/LALALA_pnqvfk.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(71,'Sleep Talk',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623445833/Music/Sleep-Talk_ly6ab6.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,31,'0000-00-00 00:00:00',NULL,NULL),(73,'Perfect 10 ft Heather Sommer',20,'',NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623472130/Music/Unknown_Brain_-_Perfect_10_feat._Heather_Sommer_NCS_Lyric_Video_hrv3wq.mp3',19000015,'https://res.cloudinary.com/van-nam/image/upload/v1623475648/Image/Song/unknown_brain_ue4gtz.jpg\r\n',3,24,'2018-07-11 00:00:00','2021-06-19 02:24:07',NULL),(74,'MATAFAKA ft Marvin Divine',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623472131/Music/Unknown_Brain_-_MATAFAKA_feat._Marvin_Divine_NCS_Release_qax5gz.mp3',49125086,'https://res.cloudinary.com/van-nam/image/upload/v1623475648/Image/Song/unknown_brain_ue4gtz.jpg',3,24,'2017-05-18 12:47:15','2021-06-18 00:01:23',NULL),(75,'Superhero ft Chris Linton',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623477052/Music/Unknown_Brain_-_Superhero_feat._Chris_Linton_NCS_Release_bdiaxs.mp3',101952220,'https://res.cloudinary.com/van-nam/image/upload/v1623475648/Image/Song/unknown_brain_ue4gtz.jpg',3,24,'2016-11-27 12:47:15','2021-06-12 13:07:49',NULL),(76,'Control ft Jex',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623477050/Music/Unknown_Brain_x_Rival_-_Control_feat._Jex_NCS_Release_twz65r.mp3',51176608,'https://res.cloudinary.com/van-nam/image/upload/v1623475648/Image/Song/unknown_brain_ue4gtz.jpg',3,24,'2018-10-20 00:00:00','2021-06-19 02:28:39',NULL),(81,'Why Do I ft Bri Tolani',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623477053/Music/Unknown_Brain_-_Why_Do_I__feat._Bri_Tolani_NCS_Release_ae21dc.mp3',43035431,'https://res.cloudinary.com/van-nam/image/upload/v1623475648/Image/Song/unknown_brain_ue4gtz.jpg',3,24,'2018-04-21 12:58:18','2021-06-12 13:09:41',NULL),(82,'Say Goodbye ft Marvin Divine',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623477056/Music/Unknown_Brain_-_Say_Goodbye_ft._Marvin_Divine_NCS_Release_oltxnr.mp3',20271762,'https://res.cloudinary.com/van-nam/image/upload/v1623475648/Image/Song/unknown_brain_ue4gtz.jpg',3,24,'2019-11-09 12:58:18','2021-06-19 02:26:40',NULL),(83,'We\'re All Square',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623477968/Music/Were-All-Square_vtzz6k.wav',7,'https://res.cloudinary.com/van-nam/image/upload/v1623476040/Music/NCSD_xhgncp.jpg',2,36,'0000-00-00 00:00:00','2021-06-18 15:59:36',NULL),(84,'Try Angle',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623477961/Music/Try-Angle_o3sxxc.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623476040/Music/NCSD_xhgncp.jpg',2,36,'0000-00-00 00:00:00',NULL,NULL),(90,'Energy',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623478656/Music/Elektronomia_-_Energy_NCS_Release_glwetx.mp3',73,'https://res.cloudinary.com/van-nam/image/upload/v1623478893/Image/Song/elektronomia_yoafig.jpg',4,27,'0000-00-00 00:00:00','2021-06-23 09:56:02',NULL),(91,'Sky High',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623478657/Music/Elektronomia_-_Sky_High_NCS_Release_f0wowo.mp3',19,'https://res.cloudinary.com/van-nam/image/upload/v1623478893/Image/Song/elektronomia_yoafig.jpg',4,27,'0000-00-00 00:00:00','2021-06-17 23:45:55',NULL),(92,'Limitless',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623478658/Music/Elektronomia_-_Limitless_dagd2p.mp3',14,'https://res.cloudinary.com/van-nam/image/upload/v1623478893/Image/Song/elektronomia_yoafig.jpg',4,27,'0000-00-00 00:00:00','2021-06-17 23:45:59',NULL),(93,'Fire',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623478659/Music/Elektronomia_-_Fire_qj4cgr.mp3',13,'https://res.cloudinary.com/van-nam/image/upload/v1623478893/Image/Song/elektronomia_yoafig.jpg',4,27,'0000-00-00 00:00:00','2021-06-23 09:56:12',NULL),(94,'Summersong',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623478659/Music/Elektronomia_-_Summersong_2018_NCS_Release_nyxich.mp3',14,'https://res.cloudinary.com/van-nam/image/upload/v1623478893/Image/Song/elektronomia_yoafig.jpg',4,27,'2021-06-12 13:28:14','2021-06-17 21:15:52',NULL),(95,'Where We Started ft Jex',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480136/Music/Lost_Sky_-_Where_We_Started_feat._Jex_NCS_Release_wclnmt.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,30,'0000-00-00 00:00:00','2021-06-12 13:46:50',NULL),(96,'Fearless ft Chris Linton',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480133/Music/Lost_Sky_-_Fearless_pt._II_feat._Chris_Linton_Music_Video_Edit_c6otu9.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,30,'0000-00-00 00:00:00','2021-06-16 21:32:38',NULL),(97,'Dreams ft Sara Skinner',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480147/Music/Lost_Sky_-_Dreams_pt._II_feat._Sara_Skinner_NCS_Release_rred01.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,30,'0000-00-00 00:00:00',NULL,NULL),(98,'Lost',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480158/Music/Lost_Sky_-_Lost_NCS_Release_cdmvkz.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,30,'0000-00-00 00:00:00','2021-06-12 15:21:16',NULL),(99,'Why We Lose ft Coleman Trapp',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481430/Music/Cartoon_-_Why_We_Lose_feat._Coleman_Trapp_NCS_Release_u2dimw.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623481047/Image/Song/cartoon_rjozii.jpg',6,31,'0000-00-00 00:00:00',NULL,NULL),(100,'C U Again ft Mikk Mäe',20,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481431/Music/Cartoon_-_C_U_Again_feat._Mikk_M%C3%A4e_Cartoon_vs_Futuristik_VIP_NCS_Release_toeyv7.mp3',2,'https://res.cloudinary.com/van-nam/image/upload/v1623481047/Image/Song/cartoon_rjozii.jpg',6,31,'0000-00-00 00:00:00','2021-06-19 00:06:56',NULL),(101,'On & On ft Daniel Levi',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481438/Music/Cartoon_-_On_On_feat._Daniel_Levi_NCS_Release_nwbele.mp3',2,'https://res.cloudinary.com/van-nam/image/upload/v1623481047/Image/Song/cartoon_rjozii.jpg',6,31,'0000-00-00 00:00:00','2021-06-19 18:42:14',NULL),(102,'Candyland',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481400/Music/Tobu_-_Candyland_NCS_Release_j7ypjs.mp3',86,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'0000-00-00 00:00:00','2021-07-15 16:36:43',NULL),(103,'Hope',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481403/Music/Tobu_-_Hope_NCS_Release_wi8yct.mp3',32,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'0000-00-00 00:00:00','2021-07-15 16:36:53',NULL),(104,'Life',16,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481403/Music/Tobu_-_Life_NCS_Release_plnluz.mp3',23,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'0000-00-00 00:00:00','2021-06-18 03:01:32',NULL),(105,'Mesmerize',16,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481408/Music/Tobu_-_Mesmerize_NCS_Release_ccqvcr.mp3',8,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'0000-00-00 00:00:00','2021-06-18 03:01:36',NULL),(106,'Sunburst',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481408/Music/Tobu_Itro_-_Sunburst_NCS_Release_epzqfk.mp3',10000006,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'2021-06-17 01:12:36','2021-06-18 03:01:40',NULL),(107,'Infectious',16,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481408/Music/Tobu_-_Infectious_NCS_Release_e96hro.mp3',6,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'0000-00-00 00:00:00','2021-07-15 16:37:05',NULL),(108,'Roots',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481412/Music/Tobu_-_Roots_NCS_Release_bxatcv.mp3',4,'https://res.cloudinary.com/van-nam/image/upload/v1623481852/Image/Song/tobu_apvnsz.jpg',7,32,'0000-00-00 00:00:00','2021-06-15 22:12:49',NULL),(109,'Firefly',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623482011/Music/Jim_Yosef_-_Firefly_NCS_Release_yrpuzb.mp3',52,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-07-15 16:37:58',NULL),(110,'Lights',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623482008/Music/Jim_Yosef_-_Lights_NCS_Release_uw71y3.mp3',5,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-07-15 16:38:04',NULL),(111,'Forces ft Ivan Jamile & Kédo Rebelle',16,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623482005/Music/Jim_Yosef_-_Forces_feat._Ivan_Jamile_K%C3%A9do_Rebelle_NCS_Release_eadx5x.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-06-12 14:54:17',NULL),(112,'Can\'t Wait ft Anna Yvette',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623482002/Music/Jim_Yosef_-_Can_t_Wait_feat._Anna_Yvette_NCS_Release_hh43oc.mp3',2,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-06-20 20:59:47',NULL),(113,'Linked ft Anna Yvette',16,'',NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481999/Music/Jim_Yosef_Anna_Yvette_-_Linked_NCS_Release_t0k2pd.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-06-19 23:17:18',NULL),(114,'Eclipse',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623481994/Music/Jim_Yosef_-_Eclipse_NCS_Release_dvd0gz.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-06-17 19:03:07',NULL),(115,'Arrow',16,NULL,'oke la','https://res.cloudinary.com/van-nam/video/upload/v1623481987/Music/Jim_Yosef_-_Arrow_NCS_Release_fl3vek.mp3',144,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg',8,33,'0000-00-00 00:00:00','2021-06-19 02:23:47',NULL),(116,'Cloud 9 ft Itro',16,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623483629/Music/Itro_Tobu_-_Cloud_9_NCS_Release_wze46g.mp3',3,'https://res.cloudinary.com/van-nam/image/upload/v1623482598/Image/Song/jim_yosef_ykeyv7.jpg',8,33,'0000-00-00 00:00:00','2021-06-16 21:28:27',NULL),(117,'Fearless',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480133/Music/Lost_Sky_-_Fearless_pt._II_feat._Chris_Linton_Music_Video_Edit_c6otu9.mp3',21,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,34,'0000-00-00 00:00:00','2021-06-23 09:57:46',NULL),(118,'Where We Started ft Jex',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480136/Music/Lost_Sky_-_Where_We_Started_feat._Jex_NCS_Release_wclnmt.mp3',6,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,34,'0000-00-00 00:00:00','2021-06-23 09:57:53',NULL),(119,'Dreams ft Sara_Skinner',16,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480147/Music/Lost_Sky_-_Dreams_pt._II_feat._Sara_Skinner_NCS_Release_rred01.mp3',4,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,34,'0000-00-00 00:00:00','2021-06-18 03:23:34',NULL),(120,'Lost',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623480158/Music/Lost_Sky_-_Lost_NCS_Release_cdmvkz.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623479847/Image/Song/lostsky_f3mimk.jpg',5,34,'0000-00-00 00:00:00','2021-06-12 14:57:42',NULL),(121,'Mansa Musa',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484046/Music/Mansa-Musa_iwdim3.wav',11,'https://res.cloudinary.com/van-nam/image/upload/v1623484128/Image/Singer/34800554_2156624044558687_3591403716785209344_n_nssite.jpg',2,35,'0000-00-00 00:00:00','2021-06-18 16:21:36',NULL),(122,'Faces',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623483399/Music/Faces_cq1skj.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(123,'Steady Rocking',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623483562/Music/Steady-Rocking_u1e1p7.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(124,'Incognito',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623483629/Music/Itro_Tobu_-_Cloud_9_NCS_Release_wze46g.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(125,'Hazy Days',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623483726/Music/Hazy-Days_zywymw.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(126,'The Emperor',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623483871/Music/The-Emperor_krtadr.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(127,'Woke',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484899/Music/Woke_ldf9fv.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(128,'Natural',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484912/Music/Natural_fdh4so.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(129,'Tour Guide',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484926/Music/Tour-Guide_luhcis.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(130,'Eighty Two',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484940/Music/Eighty-Two_wfqwhy.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(131,'Uptown Bounce',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484953/Music/Uptown-Bounce_bowyhq.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(132,'Southside',18,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484966/Music/Southside_lbkqhx.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(133,'Matrix',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484979/Music/Matrix_hnmahn.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(134,'Zen Garden',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623484992/Music/Zen-Garden_isvrdj.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(135,'Homecoming',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623485009/Music/Homecoming_ujjtlg.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(137,'Guess Who',17,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623485022/Music/Guess-Who_grhr0o.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,35,'0000-00-00 00:00:00',NULL,NULL),(138,'Candyland',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623487578/Image/Playlist/Infinity/Tobu_-_Candyland_NCS_Release_ddlxce.mp3',20,'https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg',2,37,'0000-00-00 00:00:00','2021-06-18 16:22:12',1),(139,'Force',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623487586/Image/Playlist/Infinity/Alan_Walker_-_Force_oackze.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg',2,37,'0000-00-00 00:00:00','2021-06-15 19:09:48',1),(140,'Hollah',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623487577/Image/Playlist/Infinity/Disfigure_-_Hollah_NCS_Release_clheur.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg',2,37,'0000-00-00 00:00:00','2021-06-15 21:07:28',1),(141,'Advantures',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623487579/Image/Playlist/Infinity/William_Ekh_-_Adventures_feat._Alexa_Lusader_NCS_Release_jgwloi.mp3',7,'https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg',2,37,'0000-00-00 00:00:00','2021-06-18 16:22:31',1),(142,'Entropy',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623487579/Image/Playlist/Infinity/Distrion_Alex_Skrindo_-_Entropy_NCS_Release_w7rmlc.mp3',4,'https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg',2,37,'0000-00-00 00:00:00','2021-06-15 21:07:00',1),(143,'Like the Instrumental',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488680/Music/Like-That-Instrumental_m0uulj.wav',3,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00','2021-06-17 23:52:41',NULL),(144,'Pesto',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488693/Music/Pesto-Instrumental_gngzfg.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00',NULL,NULL),(145,'Lke That',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488704/Music/Like-That_zixygq.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00',NULL,NULL),(146,'All we ever needed',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488729/Music/All-We-Ever-Needed_kheguq.wav',12,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00','2021-06-17 15:01:14',NULL),(147,'Euphoria',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488749/Music/Euphoria-Instrumental_mhmgib.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00',NULL,NULL),(148,'Disco nights',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488759/Music/Disco-Nights_t7ydx2.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00',NULL,NULL),(149,'Its all good',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488773/Music/Its-All-Good-feat.-Nickie-Conley_lrc7vp.wav',0,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00',NULL,NULL),(150,'All I need',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488792/Music/All-I-Need_yx6q2l.wav',9,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00','2021-06-17 00:50:44',NULL),(151,'Last Night',22,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623488811/Music/Late-Night_swpxl3.wav',1,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',2,42,'0000-00-00 00:00:00','2021-06-15 18:53:14',NULL),(152,'Holding On',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490167/Image/Playlist/NCS:%20Alpha/Floatinurboat_x_Chris_Linton_-_Holding_On_NCS_Release_pmmlic.mp3',4,'https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg',2,49,'0000-00-00 00:00:00','2021-06-20 18:30:15',2),(153,'No Lullaby',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490168/Image/Playlist/NCS:%20Alpha/Mountkid_-_No_Lullaby_NCS_Release_ddf2i8.mp3',2,'https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg',2,49,'0000-00-00 00:00:00','2021-06-19 00:11:13',2),(154,'Under Water',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490163/Image/Playlist/NCS:%20Alpha/Fareoh_-_Under_Water_NCS_Release_ujpn6o.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg',2,49,'0000-00-00 00:00:00',NULL,2),(155,'Everything',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490173/Image/Playlist/NCS:%20Alpha/Diamond_Eyes_-_Everything_NCS_Release_kueqsc.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg',2,49,'0000-00-00 00:00:00',NULL,2),(156,'Bubble',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490173/Image/Playlist/NCS:%20Alpha/Diamond_Eyes_-_Everything_NCS_Release_kueqsc.mp3',2,'https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg',2,49,'0000-00-00 00:00:00','2021-06-19 00:06:23',2),(157,'Get In',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490911/Image/Playlist/NCS:%20Colors/3rd_Prototype_-_Get_In_NCS_Release_gsshpp.mp3',2,'https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg',2,40,'0000-00-00 00:00:00','2021-06-18 13:07:24',3),(158,'Your Stories',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490907/Image/Playlist/NCS:%20Colors/Cartoon_-_Your_Stories_feat._Koit_Toome_NCS_Release_drh9qu.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg',2,40,'0000-00-00 00:00:00',NULL,3),(159,'Make Me Move',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490911/Image/Playlist/NCS:%20Colors/Culture_Code_-_Make_Me_Move_feat._Karra_Tobu_Remix___NCS_Release_cecytj.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg',2,40,'0000-00-00 00:00:00',NULL,3),(160,'Weakness',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490910/Image/Playlist/NCS:%20Colors/Prismo_-_Weakness_NCS_Release_napptb.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg',2,40,'0000-00-00 00:00:00',NULL,3),(161,'Falling Up',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623490915/Image/Playlist/NCS:%20Colors/Y_V_-_Falling_Up_NCS_Release_xnzwt3.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg',2,40,'0000-00-00 00:00:00',NULL,3),(162,'Close',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492021/Image/Playlist/NCS:%20The%20Best%20of%202016/IZECOLD_-_Close_feat._Molly_Ann_Brooks_Remix___NCS_x_FHM_Release_al4ife.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623489158/Image/Playlist/NCS:%20The%20Best%20of%202016/ncs_2016_4000_wlwwc2.jpg',2,39,'0000-00-00 00:00:00','2021-06-23 19:39:00',7),(163,'Feel Good',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492016/Image/Playlist/NCS:%20The%20Best%20of%202016/Syn_Cole_-_Feel_Good_NCS_Release_vauvg5.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623489158/Image/Playlist/NCS:%20The%20Best%20of%202016/ncs_2016_4000_wlwwc2.jpg',2,39,'0000-00-00 00:00:00',NULL,7),(164,'Puzzle',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492014/Image/Playlist/NCS:%20The%20Best%20of%202016/RetroVision_-_Puzzle_NCS_Release_gefey6.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623489158/Image/Playlist/NCS:%20The%20Best%20of%202016/ncs_2016_4000_wlwwc2.jpg',2,39,'0000-00-00 00:00:00',NULL,7),(165,'Savage',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492022/Image/Playlist/NCS:%20The%20Best%20of%202016/Paul_Flint_-_Savage_NCS_Release_c71f2x.mp3',0,'https://res.cloudinary.com/van-nam/image/upload/v1623489158/Image/Playlist/NCS:%20The%20Best%20of%202016/ncs_2016_4000_wlwwc2.jpg',2,39,'0000-00-00 00:00:00',NULL,7),(166,'Something More',15,NULL,'You\'re rolling stone but I am a cannonball\r\nYou\'re not fooling me, not fooling anyone\r\nGot you head in the cloud you\'re delusional\r\nIn the notion of all that\'s emotional\r\nBest been sure I\'ve been there when you\'re looking for\r\nSomething more\r\nSomething more\r\nSomething more\r\nSomething\r\nYou\'re rolling stone but I am a cannonball\r\nYou\'re not fooling me, not fooling anyone\r\nGot you head in the cloud you\'re delusional\r\nIn the notion of all that\'s emotional\r\nBest been sure I\'ve been there when you\'re looking for\r\nSomething more\r\nSomething more\r\nSomething more\r\nSomething','https://res.cloudinary.com/van-nam/video/upload/v1623492497/Image/Playlist/NCS:%20Reloaded/WiDE_AWAKE_-_Something_More_NCS_Release_ygshzd.mp3',3632892,'https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg',2,50,'2018-12-12 00:00:00','2021-07-17 09:56:46',5),(167,'Return To The Wild',15,NULL,'You turn towards me and look so weak\r\nI\'ve never seen you with such tired eyes\r\nAnd everything we said we\'d be\r\nWe just traded for a suit coat and a tie\r\nMaybe it\'s time we got out\r\nRun underneath the rows of trees\r\nI\'ll see you where the ocean meet the sky\r\nUnder your toes, Fire grows\r\nYou are ready for a different kind of life\r\nJust sign and fold it\r\nThe wind is calling\r\nWe must return to the wild\r\nJust sign and fold it\r\nThe wind is calling\r\nWe must return to the wild\r\nFollow me down\r\nThere\'s no one around\r\nLay back and take your socks and shoes right off\r\nThat natural light\r\nIs so damn polite\r\nCan make you feel just like you were young\r\nAgain\r\nStanding underneath the rows of trees\r\nI can see you where the ocean meets the sky\r\nUnder our clothes, Fire grows\r\nWe are ready for this life of running wild\r\nRun underneath the rows of trees\r\nI\'ll see you where the ocean meet the sky\r\nUnder your toes, Fire grows\r\nYou are ready for different kind of life\r\nJust sign and fold it\r\nThe wind is calling\r\nWe must return to the wild\r\nJust sign and fold it\r\nThe wind is calling\r\nWe must return to the wild','https://res.cloudinary.com/van-nam/video/upload/v1623492493/Image/Playlist/NCS:%20Reloaded/Tobu_-_Return_To_The_Wild_abn2s3.mp3',15,'https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg',2,50,'0000-00-00 00:00:00','2021-07-12 20:25:28',5),(168,'Never Have I Felt This',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492495/Image/Playlist/NCS:%20Reloaded/Koven_-_Never_Have_I_Felt_This_NCS_Release_hlmyvs.mp3',15,'https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg',2,50,'0000-00-00 00:00:00','2021-07-12 16:01:08',5),(169,'All Stops Now',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492487/Image/Playlist/NCS:%20Reloaded/JPB_-_All_Stops_Now_feat._Soundr_NCS_Release_p7z5oe.mp3',21,'https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg',2,50,'0000-00-00 00:00:00','2021-06-20 18:10:27',5),(170,'Drakkar',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492482/Image/Playlist/NCS:%20Reloaded/Distrion_Electro-Light_-_Drakkar_NCS_Release_udprqh.mp3',10,'https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg',2,50,'0000-00-00 00:00:00','2021-06-20 18:10:30',5),(171,'Linked',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492963/Image/Playlist/NCS:%20The%20Best%20of%202017/Jim_Yosef_Anna_Yvette_-_Linked_NCS_Release_aubael.mp3',6,'https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg',2,47,'0000-00-00 00:00:00','2021-06-20 20:32:44',8),(172,'Runaway',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492956/Image/Playlist/NCS:%20The%20Best%20of%202017/Halcyon_feat._Valentina_Franco_-_Runaway_Culture_Code_Remix_aokcf1.mp3',4,'https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg',2,47,'0000-00-00 00:00:00','2021-06-18 02:59:30',8),(173,'Hold On',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492957/Image/Playlist/NCS:%20The%20Best%20of%202017/Prismo_-_Hold_On_ybqp5f.mp3',3,'https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg',2,47,'0000-00-00 00:00:00','2021-06-18 02:59:36',8),(174,'Home',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492957/Image/Playlist/NCS:%20The%20Best%20of%202017/Jordan_Schor_Harley_Bird_-_Home_NCS_Release_th9hwr.mp3',1,'https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg',2,47,'0000-00-00 00:00:00','2021-06-12 17:26:45',8),(175,'Bleed',15,NULL,NULL,'https://res.cloudinary.com/van-nam/video/upload/v1623492955/Image/Playlist/NCS:%20The%20Best%20of%202017/Axol_The_Tech_Thieves_-_Bleed_NCS_Release_oyvgff.mp3',34,'https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg',2,47,'0000-00-00 00:00:00','2021-06-19 00:16:53',8),(176,'Slow - diviners x riell ',15,NULL,'Let\'s take it slow\r\nWhere you go, I go too\r\nAnd if you hit the bottom, I\'m going down with you\r\nLet\'s take it slow\r\nWho cares where we gotta be\r\nYou know you\'ll have a good time, wherever you\'re with me\r\nLet\'s take it\r\nYou ask me how we got here, \'cause you don\'t know how\r\nYou say we\'re taking on water, yeah, we\'re sinking now\r\nYou\'re looking all concerned like we\'re gonna drown\r\nBut we both know how to swim, no worries, let\'s float for now\r\nLet\'s take it slow\r\nWhere you go, I go too\r\nAnd if you hit the bottom, I\'m going down with you\r\nLet\'s take it slow\r\nWho cares where we gotta be\r\nYou know you\'ll have a good time, wherever you\'re with me\r\nLet\'s take it\r\nI know I\'m not easy, I drive you out your mind\r\nAnd there are days I hate you, but baby, you\'re still mine\r\nAnd man, we have the best times, no matter what we do\r\nAnd even when we don\'t, there\'s nobody I\'d rather choose\r\nLet\'s take it slow\r\nWhere you go, I go too\r\nAnd if you hit the bottom, I\'m going down with you\r\nLet\'s take it\r\nLet\'s take it slow\r\nWho cares where we gotta be\r\nYou know you\'ll have a good time, wherever you\'re with me\r\nLet\'s take it slow\r\nWhere you go, I go to\r\nAnd if you hit the bottom, I\'m going down with you\r\nLet\'s take it slow\r\nWho cares where we gotta be\r\nYou know you\'ll have a good time, wherever you\'re with me','https://res.cloudinary.com/van-nam/video/upload/v1623950013/Music/Diviners_X_Riell_-_Slow_NCS_Release_rdeomh.mp3',1937482,'https://res.cloudinary.com/van-nam/image/upload/v1623949830/Image/Song/slow_rtlihd.jpg',2,1,'2020-08-07 00:09:03','2021-06-18 03:29:29',NULL),(180,'On & On ft Daniel Levi',15,NULL,'Hold me close \'til I get up\r\nTime is barely on our side\r\nI don\'t wanna waste what\'s left\r\nThe storms we chase are leading us\r\nAnd love is all we\'ll ever trust, yeah\r\nNo, I don\'t wanna waste what\'s left\r\nAnd on and on we\'ll go\r\nThrough the wastelands, through the highways\r\n\'Til my shadow turns to sun rays\r\nAnd on and on we\'ll go\r\nThrough the wastelands, through the highways\r\nAnd on and on we\'ll go\r\nOh, on we\'ll go\r\nFinding life along the way\r\nMelodies we haven\'t played\r\nNo, I don\'t want no rest\r\nEchoin\' around these walls\r\nFighting to create a song (yeah)\r\nI don\'t wanna miss a beat\r\nAnd on and on we\'ll go\r\nThrough the wastelands, through the highways\r\n\'Til my shadow turns to sun rays\r\nAnd on and on we\'ll go\r\nThrough the wastelands, through the highways\r\nAnd on and on we\'ll go\r\nAnd we\'ll grow in number\r\nFueled by thunder, see the horizon\r\nTurn us to thousands\r\nAnd we\'ll grow in number\r\nFueld by thunder, see the horizon\r\nTurn us to thousands\r\nAnd on and on we\'ll go\r\nThrough the wastelands, through the highways\r\n\'Til my shadow turns to sun rays\r\nAnd on and on we\'ll go\r\nThrough the wastelands, through the highways\r\nAnd on and on we\'ll go','https://res.cloudinary.com/van-nam/video/upload/v1623481438/Music/Cartoon_-_On_On_feat._Daniel_Levi_NCS_Release_nwbele.mp3',419369199,'https://res.cloudinary.com/van-nam/image/upload/v1624003565/Image/Song/cartoons_pmgyad.jpg',6,53,'2015-07-09 00:00:00','2021-07-12 21:00:17',NULL),(181,'Why We Lose ft Coleman Trapp',15,'','I don\'t know what you want\r\nLet\'s have a bit of fun \'til I downfall\r\nMy love, if you feel like I do right now\r\nDon\'t say you\'re on the run to the other side\r\nMy love\r\nI don\'t know what you want\r\nLet\'s have a bit of fun \'til I downfall\r\nMy love, if you feel like I do right now\r\nDon\'t say you\'re on the run to the other side\r\nMy love\r\nYou say you wanna try\r\nBut you never do\r\nSugar, there\'s a reason why we lose\r\nBaby come on\r\nYou say you wanna try but you never do\r\nSugar, there\'s a reason why we lose\r\nYou say you wanna cry but you never do\r\nSugar, there\'s a reason why we lose','https://res.cloudinary.com/van-nam/video/upload/v1623481430/Music/Cartoon_-_Why_We_Lose_feat._Coleman_Trapp_NCS_Release_u2dimw.mp3',18,'https://res.cloudinary.com/van-nam/image/upload/v1624003565/Image/Song/cartoons_pmgyad.jpg',6,53,'0000-00-00 00:00:00','2021-07-12 18:08:20',NULL),(182,'C U Again ft Mikk Mäe',15,'','There\'s a distance between us\r\nIt\'s getting hard to reach out\r\nHaven\'t seen you in seasons\r\nFor all I hear is your voice\r\nI know my limits\r\nYou can break me down but\r\nI\'ll stay till the finish line\r\n\'Cause I\'ve been counting minutes\r\nFor quite some time now\r\nJust to see you again\r\nAnd I\'ve been counting days\r\nTo get a way\r\nTo see you again\r\nSee you again\r\nBeen fighting waves\r\nTo get a way\r\nTo see you again\r\nSee you again\r\nTo see you again\r\nTo see you again\r\nWe\'ve got millions of reasons\r\nTo let it all go\r\nHope we\'re not too broken\r\nI know I\'m not always strong\r\nAnd I\'ve been counting days\r\nTo get away\r\nTo see you again\r\nSee you again\r\nBeen fighting waves\r\nTo get a way\r\nTo see you again\r\nSee you again\r\nTo see you again\r\nTo see you again\r\nTo see you again\r\nTo see you again','https://res.cloudinary.com/van-nam/video/upload/v1623481431/Music/Cartoon_-_C_U_Again_feat._Mikk_M%C3%A4e_Cartoon_vs_Futuristik_VIP_NCS_Release_toeyv7.mp3',39453990,'https://res.cloudinary.com/van-nam/image/upload/v1624003565/Image/Song/cartoons_pmgyad.jpg',6,53,'2016-12-31 00:00:00','2021-06-20 21:01:53',NULL),(184,'Chạm Đáy Nỗi Đau',18,NULL,'Luôn bên em là tôi...\r\nLâu nay không chút thay đổi...\r\nThế nhưng bây giờ em\r\nMuốn chia tay vì tôi vẫn còn trẻ con\r\nBabe! Kajima!\r\nStay here with me! Kajima\r\nHụt hẫng ...\r\nGạt nước mắt nhớ ngày buồn nhất ...\r\nKhông muốn ai thay mình\r\nChăm sóc em những ngày tới!\r\nThoáng nghĩ đã đau lòng\r\nNhưng trách ai đây ngoài tôi...\r\nEm bước đi nhẹ nhàng...\r\n(Em đang xa tôi nhẹ nhàng)\r\nNhưng trong anh bão tố!\r\n(Giấu hết bão tố trong tim)\r\nNghẹn câu: \"Em đừng đi nữa...\"\r\nNhưng tại môi mím chặt\r\nChẳng thể một lần nói ra...\r\nChẳng ai có thể chỉ một ngày mà tốt hơn\r\nChẳng lầm lỗi nào chỉ một giây mà xóa mờ\r\nMình không thể lâu dài,\r\nChỉ vì tôi ngây ngô!\r\n(Ngốc nghếch nên tình thơ mới chết\r\nVô vọng trong bóng tối mình tôi)\r\nThời gian sẽ minh chứng tất cả\r\nVà cũng có thể\r\nNgoảnh đi bỏ mặc chúng ta\r\nNgón tay ấy buông xuôi vì chẳng cần tôi ở bên\r\nĐã từ chối cơ hội để đời tôi vững vàng\r\nNgồi khóc giữa cơn mưa\r\nMới thấu đâu là chạm đáy của nỗi đau\r\nNgày cuối ở bên\r\nMôi tôi không thể nuôi can đảm để thốt lên\r\nRời xa vòng tay\r\nEm cho tôi cảm giác nhung nhớ đến thế nào\r\nTừ biệt chưa nói câu chào mà sao muốn bước đi vội?\r\nMới... có nhau thôi lại xóa hết những yêu thương rồi?\r\nBàn tay tôi nắm chặt\r\nNgước lên bầu trời để nước mắt không tuôn rơi\r\nNgười là ánh sáng dẫn tôi tìm những giấc mơ\r\nGiờ phía trước mịt mù\r\nTrong bóng tối nỗi sợ\r\nI\'m losing you\r\nBabe! Kajima!\r\nStay here with me! Kajima\r\nHụt hẫng ... . . . . . . . .\r\nGạt nước mắt nhớ ngày buồn nhất ...\r\nTừ sâu trong lòng\r\nKhông muốn ai thay mình chăm sóc em những ngày tới!\r\nThoáng nghĩ đã đau lòng nhưng trách ai đây ngoài tôi...\r\nEm bước đi nhẹ nhàng...\r\n(Em đang xa tôi nhẹ nhàng)\r\nNhưng trong anh bão tố!\r\n(Giấu hết bão tố trong tim)\r\nNghẹn câu: \"Em đừng đi nữa...\"\r\nNhưng tại môi mím chặt\r\nChẳng thể một lần nói ra...\r\nChẳng ai có thể chỉ một ngày mà tốt hơn\r\nChẳng lầm lỗi nào chỉ một giây mà xóa mờ\r\nMình không thể lâu dài,\r\nChỉ vì tôi ngây ngô!\r\n(Ngốc nghếch nên tình thơ mới chết\r\nVô vọng trong bóng tối mình tôi)\r\nThời gian sẽ minh chứng tất cả\r\nVà cũng có thể\r\nNgoảnh đi bỏ mặc chúng ta\r\nNgón tay ấy buông xuôi\r\nVì chẳng cần tôi ở bên\r\nĐã từ chối cơ hội để đời tôi vững vàng\r\nNgồi khóc giữa cơn mưa\r\nMới thấu đâu là\r\nChạm đáy của nỗi đau\r\nBabe! Babe! Kajima...\r\nBabe! Kajima\r\nMình không thể lâu dài,\r\nChỉ vì tôi ngây ngô!\r\nThời gian sẽ minh chứng tất cả\r\nVà cũng có thể\r\nNgoảnh đi bỏ mặc chúng ta.\r\nNgón tay ấy buông xuôi\r\nVì chẳng cần tôi ở bên\r\nĐã từ chối cơ hội\r\nĐể đợi tôi vững vàng\r\nNgồi khóc giữa cơn mưa,\r\nMới thấu đâu là.\r\nChạm đáy của nỗi đau...\r\nKhông muốn ai thay mình\r\nChăm sóc em những ngày tới!\r\nThoáng nghĩ đã đau lòng\r\nNhưng trách ai đây ngoài tôi...','https://res.cloudinary.com/van-nam/video/upload/v1626100859/resource/Ch%E1%BA%A1m_%C4%90%C3%A1y_N%E1%BB%97i_%C4%90au_vbszpo.mp3',150000024,'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/cover/9/b/4/0/9b40a25f9a606520333fa79f1fdf5ea6.jpg',10,55,'2021-07-12 21:39:28','2021-07-15 16:58:44',10),(186,'Ăn Sáng Nha',18,NULL,'Chào ngày vừa lên mình cùng dậy thôi\r\nCùng ăn sáng đi nào\r\nCầu kỳ gì đâu chỉ cần vài phút là đã xong\r\nChỉ cần cùng nhau chào một ngày mới\r\nVậy thôi đã đủ rồi\r\nChỉ cần hai ta bên nhau thế thôi\r\nMới sáng ra đã thấy hôm nay cồn cào đến thế\r\nAnh ơi em thấy đói rồi\r\nMười phút nữa thôi cho anh chuẩn bị thay quần áo mới\r\nRồi đưa em đi ăn đã đời\r\nĂn phở gà cho no bụng nha?\r\nThôi em lại chẳng thích gà\r\nHay là mình đi ăn bún cá?\r\nNhưng mà đi hơi xa\r\nĂn đồ Tây hay ăn đồ Ta?\r\nHay thôi mình ăn ở nhà?\r\nVậy thì ta ở nhà ăn sáng nha\r\nChào ngày vừa lên mình cùng dậy thôi\r\nCùng ăn sáng đi nào\r\nCầu kỳ gì đâu chỉ cần vài phút là đã xong\r\nChỉ cần cùng nhau chào một ngày mới\r\nVậy thôi đã đủ rồi\r\nChỉ cần hai ta bên nhau thế thôi\r\nChào em, anh đứng đây từ sáng\r\nEm muốn ăn mì hay là ăn trứng rán?\r\nTiền anh thì có hạn nhưng tình yêu thì vô vàn\r\nDù từ sáng đến chiều tối thì anh vẫn chiều nàng\r\nEy, yêu em không cần phải nói\r\nEm mà đã đói là em đói như con sói\r\nChẳng cần đưa em đi khắp phố phường\r\nVì em ăn gì cũng được!\r\nĂn phở gà cho no bụng nha?\r\nThôi em lại chẳng thích gà\r\nHay là mình đi ăn bún cá?\r\nNhưng mà đi hơi xa (Khó thế!)\r\nĂn đồ Tây hay ăn đồ Ta?\r\nHay thôi mình ăn ở nhà?\r\nVậy thì ta ở nhà ăn sáng nha\r\nChào ngày vừa lên mình cùng dậy thôi\r\nCùng ăn sáng đi nào\r\nCầu kỳ gì đâu chỉ cần vài phút là đã xong\r\nChỉ cần cùng nhau chào một ngày mới\r\nVậy thôi đã đủ rồi\r\nChỉ cần hai ta bên nhau thế thôi\r\nLa la la, la la la\r\nTa cùng ăn sáng nha\r\nLa la la, la la la\r\nTa cùng ăn ở nhà, OK!\r\nLa la la, la la la\r\nTa cùng ăn sáng nha\r\nLa la la, la la la\r\nTa cùng ăn ở nhà\r\nAnh muốn đưa em đi cùng trời cuối đất\r\nĂn tất cả món ngon, gặp gì là ăn tất\r\nChỉ cần em no là điều quan trọng nhất\r\nVà mỗi khi em đói anh sẽ luôn thật gần\r\nAnh ơi em chẳng cần đi đâu xa\r\nDành thời gian bên nhau ta ăn sáng ở nhà\r\nPhút giây ấm áp chỉ riêng đôi ta\r\nNào ta cùng ăn sáng nha!\r\nChào ngày vừa lên mình cùng dậy thôi\r\nCùng ăn sáng đi nào\r\nCầu kỳ gì đâu chỉ cần vài phút là đã xong (là đã xong)\r\nChỉ cần cùng nhau chào một ngày mới\r\nVậy thôi đã đủ rồi (đã đủ rồi)\r\nChỉ cần hai ta bên nhau thế thôi\r\nLa la la, la la la\r\nTa cùng ăn sáng nha (cùng ăn sáng nha)\r\nLa la la, la la la\r\nTa cùng ăn ở nhà, OK!\r\nLa la la, la la la\r\nTa cùng ăn sáng nha\r\nLa la la, la la la\r\nTa cùng ăn ở nhà\r\nCùng ăn sáng nha!','https://res.cloudinary.com/van-nam/video/upload/v1626102420/resource/AnSangNha-ERIKSuniHaLinh-6288786_c3uyra.mp3',23,'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/cover/c/4/9/7/c497db7c6f698caddb80d7fd230d6be4.jpg',10,55,'2021-07-12 21:40:38','2021-07-14 18:35:47',10),(187,'Lạc Nhau Có Phải Muôn Đời',18,NULL,'Thế giới bé thế nào\r\nMình gặp nhau có phải muôn đời\r\nNgày mà người mang đến\r\nMột khúc hát không thể quên\r\nBài hát với những mơ mộng\r\nBài hát với những hy vọng\r\nCho đời ta chút vui\r\nCho đời ta chút thương.\r\n\r\nThế giới lớn thế nào\r\nMình lạc nhau có phải muôn đời\r\nDòng người vội vàng qua\r\nNgười sẽ đứng nơi đâu chờ ta\r\nChờ giữa quán xá ven đường\r\nChờ cuối góc phố năm nào\r\nXin chờ ta chút thôi, chút thôi.\r\n\r\n[ĐK:]\r\nBình minh đến đón ánh nắng sớm\r\nMình hẹn hò chốn thân quen ngày xưa\r\nHoàng hôn xuống dưới góc phố vắng\r\nMình cười nói vu vơ bao chuyện qua\r\nVì tình yêu ta trao người hết\r\nXin người đừng khiến tim này mong nhớ\r\nHãy hứa sẽ mãi bên ta.\r\n\r\nNgày vẫn thế ấm áp tiếng nói\r\nNụ cười người với bao nhiêu buồn vui\r\nChiều buông nắng gió vẫn khẽ hát\r\nThì thầm những khúc ca cho tình nhân\r\nLàm sao khi con tim nhỏ bé\r\nMơ hoài những phút giây ôm lấy người\r\nĐời như một giấc mơ mãi không tàn vì người.','https://res.cloudinary.com/van-nam/video/upload/v1626101389/resource/yt1s.com_-_MONSTAR_ERIK_L%E1%BA%A0C_NHAU_C%C3%93_PH%E1%BA%A2I_MU%C3%94N_%C4%90%E1%BB%9CI_MV_y1aqp0.mp3',10000010,'https://avatar-ex-swe.nixcdn.com/song/2017/11/29/0/6/1/1/1511950465014_640.jpg',10,55,'2021-07-12 21:48:17','2021-07-14 18:37:17',10);
/*!40000 ALTER TABLE `baihat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baihat_danhsach`
--

DROP TABLE IF EXISTS `baihat_danhsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baihat_danhsach` (
  `MABAIHAT` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MADANHSACH` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MABAIHAT`,`MADANHSACH`),
  KEY `MADANHSACH` (`MADANHSACH`),
  CONSTRAINT `baihat_danhsach_ibfk_2` FOREIGN KEY (`MADANHSACH`) REFERENCES `danhsachbaihat` (`MADANHSACH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baihat_danhsach`
--

LOCK TABLES `baihat_danhsach` WRITE;
/*!40000 ALTER TABLE `baihat_danhsach` DISABLE KEYS */;
/*!40000 ALTER TABLE `baihat_danhsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binhluan` (
  `MATHANHVIEN` int(11) NOT NULL,
  `MABAIHAT` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `THOIGIANBINHLUAN` datetime NOT NULL,
  `NOIDUNG` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DANHGIA` char(1) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`MATHANHVIEN`,`MABAIHAT`,`THOIGIANBINHLUAN`),
  KEY `MABAIHAT` (`MABAIHAT`),
  CONSTRAINT `binhluan_ibfk_2` FOREIGN KEY (`MATHANHVIEN`) REFERENCES `User` (`MATHANHVIEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casi`
--

DROP TABLE IF EXISTS `casi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casi` (
  `MACASI` int(11) NOT NULL AUTO_INCREMENT,
  `TENCASI` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TIEUSU` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `URLCASI` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MACASI`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casi`
--

LOCK TABLES `casi` WRITE;
/*!40000 ALTER TABLE `casi` DISABLE KEYS */;
INSERT INTO `casi` VALUES (4,'Ella Joy Meir',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623398700/Image/Singer/77379272_10157073050697362_9219561284171726848_n_eeymg9.jpg'),(52,'Spends Quality',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623415516/Image/Singer/10470819_10154447930730327_4883687232636872711_o_lejhwi.jpg'),(53,'Julia Gartha',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623422602/Image/Singer/161007275_161205325824656_3277980926315079709_n_ifpvqx.jpg'),(54,'Yemanjo',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623424027/Image/Singer/130303003_1355052858166906_8749035163235324676_n_aedsou.jpg'),(55,'Uknown Brain',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623424031/Image/Singer/117592738_186570669752410_130071171591085349_n_g3ybfl.jpg'),(56,'Charlie Peacock',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623481522/Image/Album/75196445_1494487870703913_5571097415030669312_n_itct27.jpg'),(57,'Scott Dugdale',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623477028/Image/Singer/scottdugdale_irunss.png'),(58,'Elektronomia ',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623478380/Image/Singer/elektronomia_cxjjg0.jpg'),(59,'Giulio Cercato',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623482078/Image/Album/54710082_qwhchz.jpg'),(60,'Cartoon',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623480862/Image/Singer/cartoon_ajwlp4.jpg'),(61,'Tobu',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623481834/Image/Singer/tobu_ralj1s.jpg'),(62,'Jim Yosef',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623482659/Image/Singer/jim_yosef_z3qdlf.jpg'),(63,'Lost Sky',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623479901/Image/Singer/lostsky_a16kgc.jpg'),(64,'Jumbo',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623484128/Image/Singer/34800554_2156624044558687_3591403716785209344_n_nssite.jpg'),(65,'NCS',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg'),(66,'Total Trap',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1623488178/Image/Singer/91DfHVoMPyL._SS500__eqha3x.jpg'),(67,'9.5 điểm',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1624096931/resource/2021-06-19_170124_awagpf.png'),(68,'Erik',NULL,'https://res.cloudinary.com/van-nam/image/upload/v1626100693/resource/erik1_xf3hks.jpg');
/*!40000 ALTER TABLE `casi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chude`
--

DROP TABLE IF EXISTS `chude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chude` (
  `MACHUDE` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TENCHUDE` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MIEUTA` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `HINHCHUDE` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MACHUDE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chude`
--

LOCK TABLES `chude` WRITE;
/*!40000 ALTER TABLE `chude` DISABLE KEYS */;
INSERT INTO `chude` VALUES ('01','Xuân',NULL,'https://res.cloudinary.com/dyd2hnvio/image/upload/v1619852731/ImageAdv/t%E1%BA%A3i_xu%E1%BB%91ng_1_htlnon.jpg'),('02','Hạ','dsadsa','https://res.cloudinary.com/dyd2hnvio/image/upload/v1619852731/ImageAdv/t%E1%BA%A3i_xu%E1%BB%91ng_1_htlnon.jpg'),('03','Thu',NULL,'https://res.cloudinary.com/dyd2hnvio/image/upload/v1619852731/ImageAdv/t%E1%BA%A3i_xu%E1%BB%91ng_1_htlnon.jpg'),('04','Đông',NULL,'https://res.cloudinary.com/dyd2hnvio/image/upload/v1619852731/ImageAdv/t%E1%BA%A3i_xu%E1%BB%91ng_1_htlnon.jpg');
/*!40000 ALTER TABLE `chude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chude_theloai`
--

DROP TABLE IF EXISTS `chude_theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chude_theloai` (
  `MACHUDE` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MATHELOAI` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MACHUDE`,`MATHELOAI`),
  KEY `MATHELOAI` (`MATHELOAI`),
  CONSTRAINT `chude_theloai_ibfk_1` FOREIGN KEY (`MACHUDE`) REFERENCES `chude` (`MACHUDE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chude_theloai`
--

LOCK TABLES `chude_theloai` WRITE;
/*!40000 ALTER TABLE `chude_theloai` DISABLE KEYS */;
INSERT INTO `chude_theloai` VALUES ('02','07'),('02','11'),('04','09');
/*!40000 ALTER TABLE `chude_theloai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhsachbaihat`
--

DROP TABLE IF EXISTS `danhsachbaihat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhsachbaihat` (
  `MADANHSACH` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MATHANHVIEN` int(11) NOT NULL,
  `TENDANHSACH` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MIEUTA` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NGAYTAO` datetime NOT NULL,
  PRIMARY KEY (`MADANHSACH`),
  KEY `MATHANHVIEN` (`MATHANHVIEN`),
  CONSTRAINT `danhsachbaihat_ibfk_1` FOREIGN KEY (`MATHANHVIEN`) REFERENCES `User` (`MATHANHVIEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhsachbaihat`
--

LOCK TABLES `danhsachbaihat` WRITE;
/*!40000 ALTER TABLE `danhsachbaihat` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhsachbaihat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichsu`
--

DROP TABLE IF EXISTS `lichsu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lichsu` (
  `MATHANHVIEN` int(11) NOT NULL,
  `MABAIHAT` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NGAYNGHE` datetime NOT NULL,
  PRIMARY KEY (`NGAYNGHE`,`MABAIHAT`,`MATHANHVIEN`),
  KEY `MABAIHAT` (`MABAIHAT`),
  KEY `MATHANHVIEN` (`MATHANHVIEN`),
  CONSTRAINT `lichsu_ibfk_2` FOREIGN KEY (`MATHANHVIEN`) REFERENCES `User` (`MATHANHVIEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichsu`
--

LOCK TABLES `lichsu` WRITE;
/*!40000 ALTER TABLE `lichsu` DISABLE KEYS */;
/*!40000 ALTER TABLE `lichsu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacsi`
--

DROP TABLE IF EXISTS `nhacsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhacsi` (
  `MANHACSI` int(11) NOT NULL AUTO_INCREMENT,
  `TENNHACSI` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TIEUSU` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`MANHACSI`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacsi`
--

LOCK TABLES `nhacsi` WRITE;
/*!40000 ALTER TABLE `nhacsi` DISABLE KEYS */;
INSERT INTO `nhacsi` VALUES (2,'None',NULL),(3,'Uknown Brain',NULL),(4,'Elektronomia',NULL),(5,'Lost Sky',NULL),(6,'Cartoon',NULL),(7,'Tobu',NULL),(8,'Jim yosef',NULL),(9,'Slow',NULL),(10,'Erik',NULL);
/*!40000 ALTER TABLE `nhacsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quangcao`
--

DROP TABLE IF EXISTS `quangcao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quangcao` (
  `MAQUANGCAO` int(11) NOT NULL AUTO_INCREMENT,
  `URLHINHQUANGCAO` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MIEUTA` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `MABAIHAT` int(11) NOT NULL,
  PRIMARY KEY (`MAQUANGCAO`),
  KEY `MABAIHAT` (`MABAIHAT`),
  CONSTRAINT `quangcao_ibfk_1` FOREIGN KEY (`MABAIHAT`) REFERENCES `baihat` (`MABAIHAT`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quangcao`
--

LOCK TABLES `quangcao` WRITE;
/*!40000 ALTER TABLE `quangcao` DISABLE KEYS */;
INSERT INTO `quangcao` VALUES (5,'https://res.cloudinary.com/van-nam/image/upload/v1623949944/Image/Banner/banner_slow_b6idhi.jpg',NULL,176),(6,'https://res.cloudinary.com/van-nam/image/upload/v1623398909/Music/artworks-000102769935-nkultb-t500x500_qxerll.jpg',NULL,8),(7,'https://res.cloudinary.com/van-nam/image/upload/v1624096433/Image/Banner/banner_limitless_gvq2nt.jpg',NULL,92),(8,'https://res.cloudinary.com/van-nam/image/upload/v1624096433/Image/Banner/banner_whywelose_jfctdp.jpg',NULL,99),(9,'https://res.cloudinary.com/van-nam/image/upload/v1624096433/Image/Banner/banner_cu_again_glqp0z.jpg',NULL,182);
/*!40000 ALTER TABLE `quangcao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taibaihat`
--

DROP TABLE IF EXISTS `taibaihat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taibaihat` (
  `MATHANHVIEN` int(11) NOT NULL,
  `MABAIHAT` char(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NGAYTAI` datetime NOT NULL,
  PRIMARY KEY (`MABAIHAT`,`MATHANHVIEN`),
  KEY `MATHANHVIEN` (`MATHANHVIEN`),
  CONSTRAINT `taibaihat_ibfk_2` FOREIGN KEY (`MATHANHVIEN`) REFERENCES `User` (`MATHANHVIEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taibaihat`
--

LOCK TABLES `taibaihat` WRITE;
/*!40000 ALTER TABLE `taibaihat` DISABLE KEYS */;
/*!40000 ALTER TABLE `taibaihat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theloai` (
  `MATHELOAI` int(11) NOT NULL AUTO_INCREMENT,
  `TENTHELOAI` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MIEUTA` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `HINHTHELOAI` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MATHELOAI`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theloai`
--

LOCK TABLES `theloai` WRITE;
/*!40000 ALTER TABLE `theloai` DISABLE KEYS */;
INSERT INTO `theloai` VALUES (15,'Điện tử','','https://res.cloudinary.com/van-nam/image/upload/v1623475637/Image/Genre/electronic_bak7et.jpg'),(16,'Thế giới','','https://res.cloudinary.com/van-nam/image/upload/v1623475633/Image/Genre/world_zvztfz.jpg'),(17,'Hiphop','','https://res.cloudinary.com/van-nam/image/upload/v1623475247/Image/Genre/hiphop_kkmziw.jpg'),(18,'Pop','','https://res.cloudinary.com/van-nam/image/upload/v1623475430/Image/Genre/pop_ro85gi.jpg'),(19,'Piano','','https://res.cloudinary.com/van-nam/image/upload/v1623476521/Image/Genre/piano_fxsgop.jpg'),(20,'Jazz','','https://res.cloudinary.com/van-nam/image/upload/v1623477718/Image/Genre/jazz_kfyoqg.jpg'),(21,'Trap','','https://res.cloudinary.com/van-nam/image/upload/v1623487978/Image/Genre/Trap_la_gi_01_ugfwmr.jpg'),(22,'R&B và Soul','','https://res.cloudinary.com/van-nam/image/upload/v1623488951/Image/Genre/r-b-1_fxolzl.png');
/*!40000 ALTER TABLE `theloai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toplist`
--

DROP TABLE IF EXISTS `toplist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toplist` (
  `MATOPLIST` int(11) NOT NULL AUTO_INCREMENT,
  `TENTOPLIST` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `URLHINHTOPLIST` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `ICONTOPLIST` text COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MATOPLIST`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toplist`
--

LOCK TABLES `toplist` WRITE;
/*!40000 ALTER TABLE `toplist` DISABLE KEYS */;
INSERT INTO `toplist` VALUES (1,'NCS: Infinity','https://res.cloudinary.com/van-nam/image/upload/v1623487066/Image/Playlist/InfintyBanner_gtqi21.png','https://res.cloudinary.com/van-nam/image/upload/v1623486992/Image/Playlist/artworks-000124937612-3kbc6y-t500x500_xq6cjr.jpg'),(2,' NCS: Alpha','https://res.cloudinary.com/van-nam/image/upload/v1623488763/Image/Playlist/NCS:%20Alpha/maxresdefault_orih8n.jpg','https://res.cloudinary.com/van-nam/image/upload/v1623488762/Image/Playlist/NCS:%20Alpha/artworks-000330733590-k7499m-t500x500_u6yllh.jpg'),(3,'NCS: Colors','https://res.cloudinary.com/van-nam/image/upload/v1623488918/Image/Playlist/NCS:%20Colors/DJ2quPkXUAApoou_tpapkm.jpg','https://res.cloudinary.com/van-nam/image/upload/v1623488919/Image/Playlist/NCS:%20Colors/R-11116067-1510145752-1990.jpeg_xpvlcw.jpg'),(5,'NCS: Reloaded','https://res.cloudinary.com/van-nam/image/upload/v1623489093/Image/Playlist/NCS:%20Reloaded/maxresdefault_1_vky5rv.jpg','https://res.cloudinary.com/van-nam/image/upload/v1623489092/Image/Playlist/NCS:%20Reloaded/artworks-000469760055-k63ntd-t500x500_d7xah6.jpg'),(7,'NCS: The Best of 2016','https://res.cloudinary.com/van-nam/image/upload/v1623489172/Image/Playlist/NCS:%20The%20Best%20of%202016/maxresdefault_3_rzytgt.jpg','https://res.cloudinary.com/van-nam/image/upload/v1623489158/Image/Playlist/NCS:%20The%20Best%20of%202016/ncs_2016_4000_wlwwc2.jpg'),(8,'NCS: The Best of 2017','https://res.cloudinary.com/van-nam/image/upload/v1623489142/Image/Playlist/NCS:%20The%20Best%20of%202017/f7eb0370f6cf16372e62c361672cda2c.1000x210x1_qgls9b.jpg','https://res.cloudinary.com/van-nam/image/upload/v1623489144/Image/Playlist/NCS:%20The%20Best%20of%202017/artworks-000278612165-nejkde-t500x500_nz5iol.jpg'),(10,'V-POP','https://res.cloudinary.com/van-nam/image/upload/v1626102261/resource/tan-binh-vpop-2019-the-luc-moi-dang-hinh-thanh-ddb0be_aekccf.jpg','https://res.cloudinary.com/van-nam/image/upload/v1626098065/resource/top_100vpop_xxxpyy.jpg');
/*!40000 ALTER TABLE `toplist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-17  9:57:01
