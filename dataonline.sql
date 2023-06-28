-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 27, 2023 lúc 06:42 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dataonline`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `iddonhang` int(11) NOT NULL,
  `idsp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` varchar(250) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`iddonhang`, `idsp`, `soluong`, `gia`) VALUES
(119, 62, 1, '3090000'),
(120, 52, 1, '15890000'),
(121, 58, 1, '350000'),
(122, 69, 1, '8590000'),
(123, 69, 1, '8590000'),
(124, 69, 1, '8590000'),
(125, 69, 1, '8590000'),
(126, 69, 1, '8590000'),
(128, 62, 1, '3090000'),
(129, 62, 1, '3090000'),
(130, 62, 1, '3090000'),
(131, 62, 1, '3090000'),
(132, 62, 1, '3090000'),
(133, 57, 1, '520000'),
(133, 67, 1, '350000'),
(133, 66, 1, '850000'),
(133, 55, 1, '5240000'),
(134, 2, 1, '24900000'),
(134, 3, 1, '21670000'),
(134, 56, 1, '4490000'),
(134, 62, 1, '3090000'),
(135, 69, 1, '8590000'),
(139, 70, 1, '125000'),
(140, 58, 9, '3150000'),
(142, 70, 1, '125000'),
(143, 69, 1, '8590000'),
(143, 70, 1, '125000'),
(144, 67, 1, '350000'),
(145, 70, 1, '125000'),
(146, 69, 1, '8590000'),
(147, 70, 1, '125000'),
(148, 68, 1, '10390000'),
(149, 71, 1, '123456'),
(150, 71, 1, '123456'),
(151, 71, 1, '246912'),
(152, 71, 1, '123456'),
(153, 71, 1, '123456'),
(154, 71, 1, '123456'),
(155, 71, 1, '123456'),
(156, 71, 1, '246912'),
(157, 71, 1, '123456'),
(158, 71, 1, '123456'),
(159, 71, 1, '123456'),
(160, 71, 1, '123456'),
(161, 71, 1, '123456'),
(162, 71, 1, '123456'),
(163, 71, 2, '246912'),
(164, 71, 1, '123456'),
(165, 70, 1, '500000'),
(166, 71, 1, '123456'),
(167, 71, 1, '123456'),
(168, 71, 1, '123456'),
(169, 71, 2, '123456'),
(170, 71, 1, '123456'),
(171, 71, 1, '123456'),
(172, 70, 1, '125000'),
(173, 66, 1, '850000'),
(176, 68, 2, '10390000'),
(177, 70, 1, '125000'),
(178, 72, 1, '20000'),
(179, 72, 1, '20000'),
(180, 72, 1, '20000'),
(181, 71, 1, '123456'),
(182, 71, 1, '123456'),
(185, 68, 1, '10390000'),
(186, 70, 1, '125000'),
(187, 70, 1, '125000'),
(188, 70, 1, '125000'),
(189, 1, 1, '19990000'),
(190, 70, 1, '125000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucsp`
--

CREATE TABLE `danhmucsp` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `hinhanh` text COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmucsp`
--

INSERT INTO `danhmucsp` (`id`, `tensanpham`, `hinhanh`) VALUES
(1, 'Trang chủ', 'https://storage.needpix.com/rsynced_images/home-2741413_1280.png'),
(2, 'Điện thoại', 'https://cdn.tgdd.vn/Products/Images/42/261888/realme-c35-thumb-new-600x600.jpg'),
(3, 'Phụ kiện', 'https://tcorder.vn/wp-content/uploads/2020/10/phu-kien-dien-thoai-ban-chay-nhat-shopee-4.jpg'),
(4, 'Cửa hàng', 'https://daisuloi.vn/wp-content/uploads/2021/09/icon-ban-do-400x400.png'),
(5, 'Thông tin', 'https://w7.pngwing.com/pngs/364/789/png-transparent-symbol-information-computer-icons-information-miscellaneous-text-logo-thumbnail.png'),
(6, 'Lịch sử mua hàng', 'https://vilas.edu.vn/wp-content/uploads/2019/07/cases-tudies.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `diachi` text COLLATE utf8_vietnamese_ci NOT NULL,
  `sodienthoai` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `tongtien` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `tinhtrang` int(2) NOT NULL DEFAULT 0,
  `zalopay` text COLLATE utf8_vietnamese_ci NOT NULL,
  `momo` text COLLATE utf8_vietnamese_ci NOT NULL,
  `ngaydathang` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `iduser`, `diachi`, `sodienthoai`, `email`, `soluong`, `tongtien`, `tinhtrang`, `zalopay`, `momo`, `ngaydathang`) VALUES
(123, 23, 'hậu giang', '0866683727', 'ttttien22032001@gmail.com', 1, '8590000', 0, '', '', '2023-05-22'),
(132, 22, 'Long Mỹ, Hậu Giang', '0923337770', 'thuytien220301@gmail.com', 1, '3090000', 2, '', '', '2023-04-12'),
(133, 22, 'Ninh Kiều, Cần Thơ', '0923337770', 'thuytien220301@gmail.com', 4, '6960000', 0, '', '', '2023-05-24'),
(134, 22, 'Cần Thơ', '0923337770', 'thuytien220301@gmail.com', 4, '54150000', 0, '', '', '2023-03-15'),
(135, 22, 'Ninh Kiều, Cần Thơ', '0923337770', 'thuytien220301@gmail.com', 1, '8590000', 0, '', '', '2023-03-29'),
(139, 17, 'Long Mỹ', '0923337770', 'tranthithuytien22032001@gmail.com', 1, '125000', 0, '', '', '2023-05-23'),
(140, 17, 'Hậu Giang', '0923337770', 'tranthithuytien22032001@gmail.com', 9, '28350000', 0, '', '', '2023-05-23'),
(175, 22, 'Hậu Giang', '0923337770', 'thuytien220301@gmail.com', 1, '850000', 0, 'ACvF6YO_sY46wtWePYtUwq7w', '', '2023-06-22'),
(176, 22, 'Cần thơ', '0923337770', 'thuytien220301@gmail.com', 2, '20780000', 0, 'ACLkDewOtKtqWBPBXwGOX5WQ', '', '2023-06-22'),
(177, 22, 'cần thơ', '0923337770', 'thuytien220301@gmail.com', 1, '125000', 0, '', '', '2023-06-23'),
(178, 22, 'hg', '0923337770', 'thuytien220301@gmail.com', 1, '20000', 0, '', '', '2023-06-23'),
(179, 22, 'ct', '0923337770', 'thuytien220301@gmail.com', 1, '20000', 0, '', '', '2023-06-23'),
(180, 22, 'ct', '0923337770', 'thuytien220301@gmail.com', 1, '20000', 0, '', '', '2023-06-23'),
(181, 22, 'dgj', '0923337770', 'thuytien220301@gmail.com', 1, '123456', 0, '', '', '2023-06-23'),
(182, 22, 'hg', '0923337770', 'thuytien220301@gmail.com', 1, '123456', 0, '', '', '2023-06-23'),
(183, 22, 'hg', '0923337770', 'thuytien220301@gmail.com', 1, '123456', 0, '', '', '2023-06-23'),
(184, 22, 'hg', '0923337770', 'thuytien220301@gmail.com', 1, '123456', 0, '', '', '2023-06-23'),
(185, 22, 'Hậu Giang', '0923337770', 'thuytien220301@gmail.com', 1, '10390000', 0, '', '', '2023-06-23'),
(186, 22, 'cần thơ', '0923337770', 'thuytien220301@gmail.com', 1, '125000', 3, '', '', '2023-06-23'),
(187, 22, 'cần thơ', '0923337770', 'thuytien220301@gmail.com', 1, '125000', 3, '', '', '2023-06-23'),
(188, 22, 'ct', '0923337770', 'thuytien220301@gmail.com', 1, '125000', 3, '', '', '2023-06-25'),
(189, 22, 'ct', '0923337770', 'thuytien220301@gmail.com', 1, '19990000', 0, '', '', '2023-06-25'),
(190, 22, 'ct', '0923337770', 'thuytien220301@gmail.com', 1, '125000', 0, '', '', '2023-06-25');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(250) COLLATE utf8_vietnamese_ci NOT NULL,
  `giasp` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `soluongkho` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `hinhanh` text COLLATE utf8_vietnamese_ci NOT NULL,
  `mota` text COLLATE utf8_vietnamese_ci NOT NULL,
  `loai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasp`, `soluongkho`, `hinhanh`, `mota`, `loai`) VALUES
(1, 'OPPO Find N2 Flip', '19990000', '0', 'https://cdn.tgdd.vn/2023/03/campaign/Tim-600x600.png', 'Màn hình : AMOLED Chính 6.8\" & Phụ 3.26\" Full HD+\r\nHệ điều hành : Android 13\r\nCamera sau: Chính 50 MP & Phụ 8 MP\r\nCamera trước: 32 MP\r\nChip: MediaTek Dimensity 9000+ 8 nhân\r\nRAM: 8 GB\r\nDung lượng lưu trữ: 256 GB\r\nSIM: 2 Nano SIM Hỗ trợ 5G\r\nPin, Sạc: 4300 mAh. 44 W', 1),
(2, 'iPhone 14 Pro Max 128GB', '24900000', '0', 'https://cdn.tgdd.vn/Products/Images/42/251192/Layer-1-476x587.jpg', 'Màn hình: OLED6.7\"Super Retina XDR\r\nHệ điều hành: iOS 16\r\nCamera sau: Chính 48 MP & Phụ 12 MP, 12 MP\r\nCamera trước: 12 MP\r\nChip: Apple A16 Bionic\r\nRAM: 6 GB\r\nDung lượng lưu trữ: 128 GB\r\nSIM: 1 Nano SIM & 1 eSIMHỗ trợ 5G\r\nPin, Sạc: 4323 mAh20 W', 1),
(3, ' Samsung Galaxy S23 Ultra 5G 256GB', '21670000', '0', 'https://cdn.tgdd.vn/Products/Images/42/249948/samsung-galaxy-s23-ultra-2-200x200.jpg', 'Màn hình: OLED6.7\"Super Retina XDR\r\nHệ điều hành: iOS 16\r\nCamera sau: Chính 48 MP & Phụ 12 MP, 12 MP\r\nCamera trước: 12 MP\r\nChip: Apple A16 Bionic\r\nRAM: 6 GB\r\nDung lượng lưu trữ: 128 GB\r\nSIM: 1 Nano SIM & 1 eSIMHỗ trợ 5G\r\nPin, Sạc: 4323 mAh20 W', 1),
(4, 'Samsung Galaxy S20 FE (8GB/256GB)', '7210000', '0', 'https://cdn.tgdd.vn/Products/Images/42/224859/samsung-galaxy-s20-fan-edition-xanh-la-thumbnew-200x200.jpeg', '\"Màn hình: Super AMOLED6.5\"\"Full HD+\r\nHệ điều hành: Android 12\r\nCamera sau: Chính 12 MP & Phụ 12 MP, 8 MP\r\nCamera trước: 32 MP\r\nChip: Snapdragon 865\r\nRAM: 8 GB\r\nDung lượng lưu trữ: 256 GB\r\nSIM: 2 Nano SIM (SIM 2 chung khe thẻ nhớ)Hỗ trợ 4G\r\nPin, Sạc: 4500 mAh25 W\"\r\n', 1),
(51, 'Điện thoại OPPO Find N2 Flip 5G', '19990000', '0', 'https://cdn.tgdd.vn/Products/Images/42/299034/oppo-n2-flip-tim-1-1.jpg', 'Màn hình\r\nCông nghệ màn hình: AMOLED\r\nĐộ phân giải: Chính: FHD+ (2520 x 1080 Pixels) & Phụ: (720 x 382 Pixels)\r\nMàn hình rộng: Chính 6.8\" & Phụ 3.26\" - Tần số quét 120 Hz & 60 Hz\r\nĐộ sáng tối đa: Chính 1200 nits & Phụ 800 nits\r\nMặt kính cảm ứng: Kính siêu mỏng Ultra Thin Glass (UTG)\r\nCamera sau \r\nĐộ phân giải: Chính 50 MP & Phụ 8 MP\r\nQuay phim: FullHD 1080p@60fps\r\nFullHD 1080p@30fps\r\n4K 2160p@30fps\r\nHD 720p@30fps\r\nHD 720p@60fps\r\nĐèn Flash: Có\r\nTính năng: AI Camera\r\nChuyên nghiệp (Pro)\r\nHDR\r\nSiêu độ phân giải\r\nZoom quang học\r\nNhãn dán (AR Stickers)\r\nLàm đẹp\r\nBộ lọc màu\r\nTrôi nhanh thời gian (Time Lapse)\r\nToàn cảnh (Panorama)\r\nBan đêm (Night Mode)\r\nQuay chậm (Slow Motion)\r\nXóa phông\r\nCamera trước\r\nĐộ phân giải: 32 MP\r\nTính năng:Nhãn dán (AR Stickers)\r\nTrôi nhanh thời gian (Time Lapse)\r\nQuay video Full HD\r\nQuay video HD\r\nXóa phông\r\nA.I Camera\r\nBộ lọc màu\r\nChụp đêm\r\nHệ điều hành & CPU\r\nHệ điều hành:  Android 13\r\nChip xử lý (CPU): MediaTek Dimensity 9000+ 8 nhân\r\nTốc độ CPU: 3.2 GHz\r\nChip đồ họa (GPU): Mali-G710 MC10\r\nBộ nhớ & Lưu trữ\r\nRAM: 8 GB\r\nDung lượng lưu trữ: 256 GB\r\nDung lượng còn lại (khả dụng) khoảng: 241 GB\r\nDanh bạ: Không giới hạn\r\nKết nối\r\nMạng di động: Hỗ trợ 5G\r\nSIM: 2 Nano SIM\r\nWifi: Dual-band (2.4 GHz/5 GHz)\r\nWi-Fi hotspot\r\nWi-Fi Direct\r\nWi-Fi 802.11 a/b/g/n/ac/ax\r\nGPS:GLONASS\r\nGPS\r\n\r\nGALILEO\r\nQZSS\r\nBluetooth: v5.3\r\nCổng kết nối/sạc: Type-C\r\nJack tai nghe: Type-C\r\nKết nối khác: OTGNFC\r\nPin & Sạc\r\nDung lượng pin: 4300 mAh\r\nLoại pin: Li-Po\r\nHỗ trợ sạc tối đa: 44 W\r\nSạc kèm theo máy: 44 W\r\nCông nghệ pin: Sạc siêu nhanh SuperVOOC\r\nTiện ích\r\nBảo mật nâng cao: Mở khoá vân tay cạnh viềnMở khoá khuôn mặt\r\nTính năng đặc biệt:\r\nCử chỉ thông minh\r\nỨng dụng kép (Nhân bản ứng dụng)\r\nThu nhỏ màn hình sử dụng một tay\r\nChế độ trẻ em (Không gian trẻ em)\r\nĐa cửa sổ (chia đôi màn hình)\r\nMở rộng bộ nhớ RAM\r\nKháng nước, bụi: IPX4\r\nGhi âm: Ghi âm mặc địnhGhi âm cuộc gọi\r\nXem phim: AVIMP4\r\nNghe nhạc: Midi \r\nMP3\r\nFLAC\r\nOGG\r\nThông tin chung\r\nThiết kế: Nguyên khối\r\nChất liệu: Khung hợp kim & Mặt lưng kính cường lực Gorilla Glass 5\r\nKích thước, khối lượng: Dài 166.2 mm - Ngang 75.2 mm - Dày 7.45 mm - Nặng 191 g\r\nThời điểm ra mắt: 04/2023\r\n', 1),
(52, 'Điện thoại Samsung Galaxy S22 Ultra 5G 128GB', '15890000', '0', 'https://cdn.tgdd.vn/Products/Images/42/235838/samsung-galaxy-s22-ultra-1-1.jpg', 'Màn hình\r\nCông nghệ màn hình: Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP\r\nĐộ phân giải: Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP\r\nMàn hình rộng:  6.8\" - Tần số quét 120 Hz\r\nĐộ sáng tối đa: 1750 nits\r\nMặt kính cảm ứng:Kính cường lực Corning Gorilla Glass Victus+\r\nCamera sau \r\nĐộ phân giải: Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP\r\nQuay phim: FullHD 1080p@240fps\r\nFullHD 1080p@60fps\r\nFullHD 1080p@30fps\r\n4K 2160p@30fps\r\n4K 2160p@60fps\r\nHD 720p@30fps\r\n8K 4320p@24fps\r\nHD 720p@960fps\r\nĐèn Flash: Đèn LED kép\r\nTính năng: Quay Siêu chậm (Super Slow Motion)\r\nAI Camera\r\nChuyên nghiệp (Pro)\r\nHDR\r\nQuay video hiển thị kép\r\nChụp bằng giọng nói\r\nChụp bằng cử chỉ\r\nZoom quang học\r\nLàm đẹp\r\nLive Photo\r\nBộ lọc màu\r\nTrôi nhanh thời gian (Time Lapse)\r\nGóc siêu rộng (Ultrawide)\r\nGóc rộng (Wide)\r\nToàn cảnh (Panorama)\r\nChống rung quang học (OIS)\r\nTự động lấy nét (AF)\r\nBan đêm (Night Mode)\r\nQuay chậm (Slow Motion)\r\nXóa phông\r\nZoom kỹ thuật số\r\nCamera trước\r\nĐộ phân giải: 40 MP\r\nTính năng: Làm đẹp A.I\r\nQuay video 4K\r\nTrôi nhanh thời gian (Time Lapse)\r\nTự động lấy nét (AF)\r\nNhận diện khuôn mặt\r\nLàm đẹp\r\nPixelMaster\r\nHDR\r\nQuay video Full HD\r\nChống rung\r\nGóc rộng (Wide)\r\nQuay video HD\r\nChụp bằng cử chỉ\r\nFlash màn hình\r\nXóa phông\r\nQuay chậm (Slow Motion)\r\nLive Photo\r\nBộ lọc màu\r\nChụp đêm\r\nHệ điều hành & CPU\r\nHệ điều hành:  Android 12\r\nChip xử lý (CPU): Snapdragon 8 Gen 1 8 nhân\r\nTốc độ CPU: 1 nhân 3 GHz, 3 nhân 2.5 GHz & 4 nhân 1.79 GHz\r\nChip đồ họa (GPU): Adreno 730\r\nBộ nhớ & Lưu trữ\r\nRAM: 8 GB\r\nDung lượng lưu trữ: 128 GB\r\nDung lượng còn lại (khả dụng) khoảng: 100GB\r\nDanh bạ: Không giới hạn\r\nKết nối\r\nMạng di động: Hỗ trợ 5G\r\nSIM: 2 Nano SIM\r\nWifi: Dual-band (2.4 GHz/5 GHz)\r\nWi-Fi hotspot\r\nWi-Fi Direct\r\nWi-Fi 802.11 a/b/g/n/ac/ax\r\nGPS:GLONASS\r\nGPS\r\n\r\nGALILEO\r\nQZSS\r\nBluetooth: v5.3\r\nCổng kết nối/sạc: Type-C\r\nJack tai nghe: Type-C\r\nKết nối khác: OTGNFC\r\nPin & Sạc\r\nDung lượng pin: 5000 mAh\r\nLoại pin: Li-Po\r\nHỗ trợ sạc tối đa: 45 W\r\nSạc kèm theo máy: 45 W\r\nCông nghệ pin: Sạc không dây\r\nSạc ngược không dây\r\nSạc pin nhanh\r\nTiện ích\r\nBảo mật nâng cao: Mở khoá vân tay cạnh viềnMở khoá khuôn mặt\r\nTính năng đặc biệt:\r\nSamsung Pay\r\nThu nhỏ màn hình sử dụng một tay\r\nTrợ lý ảo Samsung Bixby\r\nChặn cuộc gọi\r\nChặn tin nhắn\r\nSamsung DeX (Kết nối màn hình sử dụng giao diện tương tự PC)\r\nÂm thanh AKG\r\nĐa cửa sổ (chia đôi màn hình)\r\nTối ưu game (Game Booster)\r\nÂm thanh Dolby Atmos\r\nMàn hình luôn hiển thị AOD\r\nChạm 2 lần sáng màn hình\r\nKhông gian thứ hai (Thư mục bảo mật)\r\nKháng nước, bụi: IPX4\r\nGhi âm: Ghi âm mặc định. Ghi âm cuộc gọi\r\nXem phim:3GP\r\nAVI\r\nMP4\r\nFLV\r\nMKV\r\nNghe nhạc: M4A\r\nAAC\r\nMP3\r\nOGG\r\nAMR\r\nWAV\r\nThông tin chung\r\nThiết kế: Nguyên khối\r\nChất liệu: Khung hợp kim & Mặt lưng kính \r\nKích thước, khối lượng: Dài 163.3 mm - Ngang 77.9 mm - Dày 8.9 mm - Nặng 228 g\r\nThời điểm ra mắt: 02/2022\r\n', 1),
(53, 'Điện thoại Samsung Galaxy Z Flip4 5G 256GB', '13990000', '0', 'https://cdn.tgdd.vn/Products/Images/42/285030/samsung-galaxy-flip4-glr-tim-1.jpg', 'Màn hình\r\n\r\nCông nghệ màn hình:\r\n\r\nChính: Dynamic AMOLED 2X, Phụ: Super AMOLED\r\nĐộ phân giải:\r\nChính: FHD+ (2640 x 1080 Pixels) x Phụ: (260 x 512 Pixels)\r\nMàn hình rộng:\r\n\r\nChính 6.7\" & Phụ 1.9\" - Tần số quét 120 Hz\r\nĐộ sáng tối đa:\r\n1200 nits\r\nMặt kính cảm ứng:\r\n\r\nChính: Ultra Thin Glass & Phụ: Corning Gorilla Glass Victus+\r\nCamera sau\r\n\r\nĐộ phân giải:\r\n2 camera 12 MP\r\nQuay phim:\r\n\r\nFullHD 1080p@60fps\r\n\r\nFullHD 1080p@30fps\r\n\r\n4K 2160p@30fps\r\n\r\n4K 2160p@60fps\r\n\r\nHD 720p@30fps\r\n\r\nĐèn Flash:\r\n\r\nCó\r\nTính năng:\r\n\r\nQuay Siêu chậm (Super Slow Motion)\r\n\r\nAI Camera\r\n\r\nChuyên nghiệp (Pro)\r\n\r\nQuay video hiển thị kép\r\n\r\nZoom quang học\r\n\r\nLàm đẹp\r\n\r\nLive Photo\r\n\r\nHiệu ứng Bokeh\r\n\r\nBộ lọc màu\r\n\r\nTrôi nhanh thời gian (Time Lapse)\r\n\r\nGóc siêu rộng (Ultrawide)\r\n\r\nGóc rộng (Wide)\r\n\r\nToàn cảnh (Panorama)\r\n\r\nChống rung quang học (OIS)\r\n\r\nBan đêm (Night Mode)\r\n\r\nQuay chậm (Slow Motion)\r\n\r\nXóa phông\r\n\r\nZoom kỹ thuật số\r\n\r\nCamera trước\r\n\r\nĐộ phân giải:\r\n10 MP\r\nTính năng:\r\n\r\nQuay video 4K\r\n\r\nTrôi nhanh thời gian (Time Lapse)\r\n\r\nLàm đẹp\r\n\r\nQuay video Full HD\r\n\r\nGóc rộng (Wide)\r\n\r\nQuay video HD\r\n\r\nFlash màn hình\r\n\r\nXóa phông\r\n\r\nQuay chậm (Slow Motion)\r\n\r\nLive Photo\r\n\r\nBộ lọc màu\r\n\r\nChụp đêm\r\n\r\nHệ điều hành & CPU\r\n\r\nHệ điều hành:\r\nAndroid 12\r\nChip xử lý (CPU):\r\n\r\nSnapdragon 8+ Gen 1 8 nhân\r\nTốc độ CPU:\r\n1 nhân 3.18 GHz, 3 nhân 2.7 GHz & 4 nhân 2 GHz\r\nChip đồ họa (GPU):\r\n\r\nAdreno 670\r\nBộ nhớ & Lưu trữ\r\n\r\nRAM:\r\n8 GB\r\nDung lượng lưu trữ:\r\n\r\n256 GB\r\nDung lượng còn lại (khả dụng) khoảng:\r\n\r\n218.3 GB\r\nDanh bạ:\r\n\r\nKhông giới hạn\r\nKết nối\r\n\r\nMạng di động:\r\n\r\nHỗ trợ 5G\r\nSIM:\r\n\r\n1 Nano SIM & 1 eSIM\r\nWifi:\r\nDual-band (2.4 GHz/5 GHz)\r\n\r\nWi-Fi 802.11 a/b/g/n/ac/ax\r\n\r\nWi-Fi MIMO\r\n\r\n6 GHz\r\n\r\nGPS:\r\nGLONASS\r\n\r\nGPS\r\n\r\nGALILEO\r\n\r\nQZSS\r\n\r\nBEIDOU\r\n\r\nBluetooth:\r\nv5.2\r\nCổng kết nối/sạc:\r\n\r\nType-C\r\nJack tai nghe:\r\n\r\nType-C\r\nKết nối khác:\r\n\r\nOTGNFC\r\nPin & Sạc\r\n\r\nDung lượng pin:\r\n\r\n3700 mAh\r\nLoại pin:\r\n\r\nLi-Ion\r\nHỗ trợ sạc tối đa:\r\n\r\n25 W\r\nCông nghệ pin:\r\n\r\nSạc không dây\r\n\r\nSạc ngược không dây\r\n\r\nSạc pin nhanh\r\n\r\nTiết kiệm pin\r\n\r\nTiện ích\r\n\r\nBảo mật nâng cao:\r\n\r\nMở khoá vân tay cạnh viềnMở khoá khuôn mặt\r\nTính năng đặc biệt:\r\n\r\nSamsung Pay\r\n\r\nChế độ đơn giản (Giao diện đơn giản)\r\n\r\nThu nhỏ màn hình sử dụng một tay\r\n\r\nTrợ lý ảo Samsung Bixby\r\n\r\nSamsung DeX (Kết nối màn hình sử dụng giao diện tương tự PC)\r\n\r\nĐa cửa sổ (chia đôi màn hình)\r\n\r\nTối ưu game (Game Booster)\r\n\r\nChế độ trẻ em (Samsung Kids)\r\n\r\nÂm thanh Dolby Atmos\r\n\r\nMàn hình luôn hiển thị AOD\r\n\r\nỨng dụng kép (Dual Messenger)\r\n\r\nKháng nước, bụi:\r\n\r\nIPX8\r\nGhi âm:\r\n\r\nGhi âm mặc địnhGhi âm cuộc gọi\r\nXem phim:\r\n\r\n3GP\r\n\r\nAVI\r\n\r\nMP4\r\n\r\nFLV\r\n\r\nMKV\r\n\r\nNghe nhạc:\r\n\r\nM4A\r\n\r\nAAC\r\n\r\nMidi\r\n\r\nMP3\r\n\r\nFLAC\r\n\r\nOGG\r\n\r\nAMR\r\n\r\nWAV\r\n\r\nThông tin chung\r\n\r\nThiết kế:\r\n\r\nNguyên khối\r\nChất liệu:\r\n\r\nKhung nhôm & Mặt lưng kính cường lực\r\nKích thước, khối lượng:\r\n\r\nDài 165.2 mm - Ngang 71.9 mm - Dày 6.9 mm - Nặng 187 g\r\nThời điểm ra mắt:\r\n\r\n08/2022', 1),
(55, 'Tai nghe Bluetooth Sony WI-1000XM2', '5240000', '0', '55.jpg', 'Thông số kỹ thuật Tai nghe Bluetooth Sony WI-1000XM2\n\nPin:\n\nDùng 10 giờ - Sạc 3.5 giờ\nCổng sạc:\n\nType-C\nCông nghệ âm thanh:\n\nChống ồn HD QN1DSEE Extreme (Cơ chế tăng cường âm thanh kỹ thuật số)Hi-Res Audio\nTương thích:\n\niOS (iPhone)AndroidWindows\nỨng dụng kết nối:\n\nSony Headphones Connect\nTiện ích:\n\nĐệm tai đi kèmSạc nhanhTrợ lý ảo SiriTrợ lý ảo GoogleChống ồn chủ động\nHỗ trợ kết nối:\n\nBluetooth 5.0\nĐiều khiển bằng:\n\nPhím nhấn\nHãng\n\nSony. Xem thông tin hãng', 2),
(56, 'Tai nghe Bluetooth True Wireless Samsung Galaxy Buds 2 Pro R510N', '4490000', '0', '56.jpg', 'Thời gian tai nghe:\n\nDùng 8 giờ - Sạc Khoảng 70 phút\nThời gian hộp sạc:\n\nDùng 29 giờ - Sạc Khoảng 130 phút\nCổng sạc:\n\nSạc không dây QiType-C\nCông nghệ âm thanh:\n\nActive Noise Cancelling360 Reality AudioAmbient Sound\nTương thích:\n\nAndroid\nỨng dụng kết nối:\n\nSmartThings\nTiện ích:\n\nHỗ trợ sạc không dây QiChống nước IPX7Sạc nhanhChống ồn chủ động ANC3 Micro chống ồn\nHỗ trợ kết nối:\n\nBluetooth 5.3\nĐiều khiển bằng:\n\nCảm ứng chạm\nHãng\n\nSamsung. Xem thông tin hãng', 2),
(58, 'Tai nghe Chụp Tai Mozard IP-840', '350000', '0', '60.jpg', 'Công nghệ âm thanh:\n\nHãng không công bố\nTương thích:\n\nAndroid\n\niOS (iPhone)\n\nWindows\n\nJack cắm:\n\n3.5 mm\nĐộ dài dây:\n\n147 cm\nTiện ích:\n\nCó mic thoại\nKết nối cùng lúc:\n\n1 thiết bị\nĐiều khiển:\n\nPhím nhấn\nPhím điều khiển:\n\nNghe/nhận cuộc gọi\n\nPhát/dừng chơi nhạc\n\nTăng/giảm âm lượng\n\nKích thước:\n\nDài 8.2 cm - Rộng 7.2 cm - Cao 3.7 cm\nKhối lượng:\n\n210 g\nThương hiệu của:\n\nThế Giới Di Động\nSản xuất tại:\n\nTrung Quốc\nHãng:\n\nMozard. Xem thông tin hãng', 2),
(59, 'Điện thoại Xiaomi Redmi 12C 64GB', '2990000', '6', '61.jpg', 'Công nghệ âm thanh:\n\nHãng không công bố\nTương thích:\n\nAndroid\n\niOS (iPhone)\n\nWindows\n\nJack cắm:\n\n3.5 mm\nĐộ dài dây:\n\n147 cm\nTiện ích:\n\nCó mic thoại\nKết nối cùng lúc:\n\n1 thiết bị\nĐiều khiển:\n\nPhím nhấn\nPhím điều khiển:\n\nNghe/nhận cuộc gọi\n\nPhát/dừng chơi nhạc\n\nTăng/giảm âm lượng\n\nKích thước:\n\nDài 8.2 cm - Rộng 7.2 cm - Cao 3.7 cm\nKhối lượng:\n\n210 g\nThương hiệu của:\n\nThế Giới Di Động\nSản xuất tại:\n\nTrung Quốc\nHãng:\n\nMozard. Xem thông tin hãng', 1),
(62, 'Điện thoại Vivo Y21', '3090000', '0', '62.jpg', 'Màn hình\n\nCông nghệ màn hình:\n\nIPS LCD\nĐộ phân giải:\nHD+ (720 x 1600 Pixels)\nMàn hình rộng:\n\n6.51\" - Tần số quét 60 Hz\nĐộ sáng tối đa:\nHãng không công bố\nMặt kính cảm ứng:\n\nMặt kính cong 2.5D\nCamera sau\n\nĐộ phân giải:\nChính 13 MP & Phụ 2 MP\nQuay phim:\n\nFullHD 1080p@30fps\nĐèn Flash:\n\nCó\nTính năng:\n\nLấy nét theo pha (PDAF)\n\nChuyên nghiệp (Pro)\n\nHDR\n\nLive Photo\n\nTrôi nhanh thời gian (Time Lapse)\n\nToàn cảnh (Panorama)\n\nXóa phông\n\nZoom kỹ thuật số\n\nCamera trước\n\nĐộ phân giải:\n8 MP\nTính năng:\n\nTự động lấy nét (AF)\n\nNhận diện khuôn mặt\n\nLàm đẹp\n\nHDR\n\nQuay video Full HD\n\nQuay video HD\n\nXóa phông\n\nHệ điều hành & CPU\n\nHệ điều hành:\nAndroid 11\nChip xử lý (CPU):\n\nMediaTek Helio P35 8 nhân\nTốc độ CPU:\n4 nhân 2.3 GHz & 4 nhân 1.8 GHz\nChip đồ họa (GPU):\n\nIMG PowerVR GE8320\nBộ nhớ & Lưu trữ\n\nRAM:\n4 GB\nDung lượng lưu trữ:\n\n64 GB\nDung lượng còn lại (khả dụng) khoảng:\n\n52 GB\nThẻ nhớ:\n\nMicroSD, hỗ trợ tối đa 1 TB\nDanh bạ:\n\nKhông giới hạn\nKết nối\n\nMạng di động:\n\nHỗ trợ 4G\nSIM:\n\n2 Nano SIM\nWifi:\nDual-band (2.4 GHz/5 GHz)\n\nWi-Fi hotspot\n\nWi-Fi Direct\n\nWi-Fi 802.11 a/b/g/n/ac\n\nGPS:\nGLONASS\n\nGPS\n\nBEIDOU\n\nBluetooth:\nLE\n\nv5.0\n\nA2DP\n\nCổng kết nối/sạc:\n\nType-C\nJack tai nghe:\n\n3.5 mm\nKết nối khác:\n\nOTG\nPin & Sạc\n\nDung lượng pin:\n\n5000 mAh\nLoại pin:\n\nLi-Po\nHỗ trợ sạc tối đa:\n\n18 W\nSạc kèm theo máy:\n\n18 W\nCông nghệ pin:\n\nSạc pin nhanh\nTiện ích\n\nBảo mật nâng cao:\n\nMở khoá vân tay cạnh viềnMở khoá khuôn mặt\nTính năng đặc biệt:\n\nTối ưu game (Multi Turbo)Mở rộng bộ nhớ RAM\nKháng nước, bụi:\n\nKhông có\nGhi âm:\n\nGhi âm mặc định\nRadio:\n\nCó\nXem phim:\n\n3GP\n\nAVI\n\nMP4\n\nNghe nhạc:\n\nMidi\n\nMP3\n\nWAV\n\nThông tin chung\n\nThiết kế:\n\nNguyên khối\nChất liệu:\n\nKhung & Mặt lưng nhựa Polycarbonate\nKích thước, khối lượng:\n\nDài 164.26 mm - Ngang 76.08 mm - Dày 8 mm - Nặng 182 g\nThời điểm ra mắt:\n\n08/2021', 1),
(66, 'Pin sạc dự phòng Innostyle PowerMag 15W 2in1 Stand 10.000mAh PD 20W', '850000', '2', '66.jpg', 'Pin & Sạc\n\nDung lượng pin\n\n10.000 mAh\n\nKết nối\n\nNguồn\n\nLightning (5V/2.0A, 9V/2.0A) / USB-C (5V/3.0A, 9V/2.0A)\n\nTiện ích\n\nThương hiệu\n\nInnostyle\n\nTrọng lượng\n\n198 g\n\nThông số\n\nKích thước\n\n106 x 69.2 x 18.5 mm', 2),
(67, 'Ốp lưng iPhone 13 Pro Max UAG Plasma', '350000', '7', '67.jpg', 'Thông tin chung\n\nThương hiệu\n\nUAG\n\nThiết kế\n\nĐặc tính ống lưng\n\nKết cấu composite nhẹ lông vũ, thiết kế 3 lớp chống va đập toàn diện, Đạt tiêu chuẩn Drop Test quân đội Mỹ (MIL STD 810G 516.6)', 2),
(68, 'iPhone 11 Pro Max 64GB', '10390000', '5', '68.jpg', 'Màn hình\n\nĐộ phân giải\n\n1242 x 2688 pixels\n\nMàn hình rộng\n\n6.5 inches\n\nCông nghệ màn hình\n\nOLED\n\nCamera sau\n\nĐộ phân giải\n\n12 MP + 12 MP + 12 MP\n\nQuay phim\n\n2160p@24/30/60fps, 1080p@30/60/120/240fps, HDR, stereo sound rec.\n\nĐèn Flash\n\nCó\n\nCamera trước\n\nĐộ phân giải\n\n12 MP, f/2.2\n\nHệ điều hành & CPU\n\nHệ điều hành\n\niOS 13\n\nTốc độ CPU\n\nHexa-core\n\nChip xử lý (CPU)\n\nApple A13 Bionic\n\nBộ nhớ & Lưu trữ\n\nRAM\n\n4 GB\n\nBộ nhớ trong\n\n64 GB\n\nKết nối\n\nĐịnh vị GPS\n\nA-GPS, GLONASS, GALILEO, QZSS\n\nBluetooth\n\n5.0, A2DP, LE\n\nSIM\n\nNano SIM\n\nWifi\n\nWi-Fi 802.11 a/b/g/n/ac/ax, dual-band, hotspot\n\nPin & Sạc\n\nLoại pin\n\nLi-Ion\n\nCông nghệ pin\n\nSạc nhanh 18W\n\nDung lượng pin\n\n3.969 mAh\n\nTiện ích\n\nThời điểm ra mắt\n\n2019\n\nThiết kế\n\nKích thước\n\n158 x 77.8 x 8.1 mm\n\nTrọng lượng\n\n226 g', 1),
(69, 'iPhone Xs Max 256GB', '8590000', '9', '69.jpg', 'Màn hình\n\nCông nghệ màn hình\n\nSuper AMOLED\n\nĐộ phân giải\n\n1242 x 2688 pixels\n\nMàn hình rộng\n\n6.5 inch\n\nCamera sau\n\nChụp nâng cao\n\nĐiều chỉnh khẩu độ, A.I Camera, Chế độ chụp ban đêm (ánh sáng yếu), Chế độ Slow Motion, Chụp ảnh xóa phông, Zoom quang học, Tự động lấy nét, Chạm lấy nét, Nhận diện khuôn mặt, HDR, Panorama, Chống rung quang học (OIS)\n\nĐộ phân giải\n\n12 MP, f/1.8, 28mm, 1.4µm, OIS, PDAF và 12 MP, f/2.4, 52mm, 1.0µm, OIS, PDAF, 2x optical zoom\n\nQuay phim\n\n2160p@24/30/60fps, 1080p@30/60/120/240fps, HDR, stereo sound rec.\n\nĐèn Flash\n\n4 đèn LED (2 tông màu)\n\nCamera trước\n\nVideo Call\n\nCó\n\nThông tin khác\n\nNhận diện khuôn mặt, Quay video Full HD, Selfie ngược sáng HDR\n\nĐộ phân giải\n\n7 MP, f/2.2\n\nHệ điều hành & CPU\n\nChip xử lý (CPU)\n\nApple A12 Bionic\n\nTốc độ CPU\n\nHexa-core\n\nChip đồ họa (GPU)\n\nApple GPU 4 nhân\n\nHệ điều hành\n\niOS 12\n\nBộ nhớ & Lưu trữ\n\nRAM\n\n4 GB\n\nBộ nhớ trong\n\n256 GB\n\nKết nối\n\nMạng di động\n\nHỗ trợ 4G\n\nWifi\n\nWi-Fi 802.11 b/g/n, Wi-Fi Direct, Wi-Fi hotspot\n\nĐịnh vị GPS\n\nA-GPS, GLONASS\n\nBluetooth\n\nLE, A2DP, v5.0\n\nCổng kết nối/sạc\n\nLightning\n\nJack tai nghe\n\nLightning\n\nKết nối khác\n\nNFC, OTG\n\nPin & Sạc\n\nLoại pin\n\nPin chuẩn Li-Ion\n\nCông nghệ pin\n\nTiết kiệm pin, Sạc pin nhanh, Sạc pin không dây\n\nDung lượng pin\n\n3174 mAh\n\nTiện ích\n\nBảo mật nâng cao\n\nNhận diện khuôn mặt Face ID\n\nTính năng đặc biệt\n\nSạc pin nhanh, Chuẩn Kháng nước, Chuẩn kháng bụi\n\nThời điểm ra mắt\n\n2018\n\nThiết kế\n\nThiết kế\n\nNguyên khối\n\nKích thước\n\nDài 157.5 mm - Ngang 77.4 mm - Dày 7.7 mm\n\nTrọng lượng\n\n208 g\n\nChất liệu\n\nKhung thép không gỉ + mặt kính cường lực', 1),
(70, 'Miếng dán cường lực iPhone 12 Pro Max TOP FULL', '125000', '4', '70.jpg', 'Miếng dán cường lực iPhone 12 Pro Max TOP FULL', 2),
(71, 'test', '123456', '5', '71.jpg', 'mo ta', 1),
(72, 'Test', '20000', '6', '72.jpg', 'sản phẩm test', 2),
(73, 'test', '100000', '10', '73.jpg', 'mô tả sản phẩm test', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(250) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(250) COLLATE utf8_vietnamese_ci NOT NULL,
  `phonenumber` varchar(12) COLLATE utf8_vietnamese_ci NOT NULL,
  `uid` text COLLATE utf8_vietnamese_ci NOT NULL,
  `token` text COLLATE utf8_vietnamese_ci NOT NULL,
  `status` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`, `phonenumber`, `uid`, `token`, `status`) VALUES
(17, 'Tien', 'tranthithuytien22032001@gmail.com', '123456', '0866255727', '4dUm4wg546P6OYiEPQSLZPUqNQS2', 'dK_NNp5DRwCqI3TbM2vjcq:APA91bF7HRpnShuvP_QKwoNwkKml9_pgJ5Kneg-Z2mmWafxkrhdrqZLPsBIsn6Ku8gVhaIiG2iVQVbD19xIcp74_ToDt9luwPl-lccumEyjvZEueAawNRDZ-YKAr9HpLzu_efmMmxj-q', 1),
(22, 'Thủy Tiên', 'thuytien220301@gmail.com', '1234567', '0923325250', '74y0Dt6YJQfWYCiNkLC0Gja3paA3', 'f2h3pO5ZStGLx49FQGDF5b:APA91bFaSa6K-cHh1OxBWTU0rQhuWmFoqbBFPwx7C8OUAC2uiokH9fjGXkz7jZUYtG0kcAMGrxJBOsxOdqy7Na3VMjlRbDpu4jlTuvqModKkpLqcdGttHWvZBjlMZiEreURMkdyW3Dd9', 0),
(24, 'test', 'test@gmail.com', 'onfirebase', '09233123570', 'T9kN276KWpW1OxLus6ZqQ7K1f7g2', 'edpofIjKSceo2OcKY8hWir:APA91bH8Qhygj7BXp-_l_xqp-PoBthgNTl26HQxw_iCD0XifCeeS44miK6X7XrReml5lFbtChdXUpzF6A71BrOsUCINzitB64TYzaaYVHJ4PpDDbAhn52JBoqQdLgjuZrDN5W9CA6Vvg', 0),
(27, 'test3', 'test3@gmali.com', 'onfirebase', '1234567890', 'ObctnSfMscehya5YCwXxbSaUVkQ2', 'eZFoklxkTB-Wzc8yuCIEZL:APA91bEgKVCWoWogeiC5CfM9r-RYodKSpwZZycXe8m6Hahid0G9PjtyuG7bCWH10X0PpiTEsfxY3JfnWXhPWA6JbvJKLe9reSsmsFC3h4p9rbt5UuUSUxnQnU8Ez-d2Kb2pn18G_2wqv', 0),
(28, 'test4', 'test4@gmail.com', 'onfirebase', '0123456789', 'kahDNfG842ZH0k4cr3QF9xSQkQ02', 'eZFoklxkTB-Wzc8yuCIEZL:APA91bEgKVCWoWogeiC5CfM9r-RYodKSpwZZycXe8m6Hahid0G9PjtyuG7bCWH10X0PpiTEsfxY3JfnWXhPWA6JbvJKLe9reSsmsFC3h4p9rbt5UuUSUxnQnU8Ez-d2Kb2pn18G_2wqv', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danhmucsp`
--
ALTER TABLE `danhmucsp`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmucsp`
--
ALTER TABLE `danhmucsp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=191;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
