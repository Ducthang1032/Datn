-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 10, 2023 lúc 02:06 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `test`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_brand`
--

CREATE TABLE `tbl_brand` (
  `id` int(11) NOT NULL,
  `brand_name` varchar(50) DEFAULT NULL,
  `brand_desc` text DEFAULT NULL,
  `brand_status` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_brand`
--

INSERT INTO `tbl_brand` (`id`, `brand_name`, `brand_desc`, `brand_status`, `created_at`, `updated_at`) VALUES
(1, 'Honda', 'Honda là nhà sản xuất động cơ lớn nhất toàn cầu của Nhật Bản', 1, '2022-12-05 05:20:04', '2022-12-04 22:20:04'),
(2, 'Kiamorning', 'Đây là hãng xe được thành lập năm 1944.  KIA Motors là một hãng sản xuất nổi tiếng, được nhiều người ưa chuộng thứ 2 tại Hàn Quốc thuộc tập đoàn ô tô Hyundai Kia AG', 1, '2022-12-05 05:20:04', '2022-12-16 03:21:36'),
(3, 'Lexus', 'Lexus là phân khúc xe hơi hạng sang của nhà chế tạo xe ô tô Nhật Bản Toyota, là gương mặt sáng giá trong những hãng xe ô tô nổi tiếng nhất thế giới.', 1, '2022-12-16 03:22:14', '2022-12-15 20:22:14'),
(4, 'ASTON MARTIN', 'Aston Martin là hãng xe được sáng lập năm 1913, do Lionel Martin & Robert Bamford sáng lập, cũng là hãng xe được đánh giá cao cấp trong các hãng xe ô tô nổi tiếng nhất thế giới.', 1, '2022-12-16 03:22:41', '2022-12-15 20:22:41'),
(5, 'BENTLEY', 'Được sáng lập năm 1919, bởi H. M. Bentley, có trụ sở chính tại Crewe, Anh, Bentley đã làm hài lòng giới hâm mộ bởi những chiếc xe hạng sang chất lượng.', 1, '2022-12-16 03:23:08', '2022-12-15 20:23:08'),
(6, 'RANDROVER', 'Đây là một trong các hãng xe Anh Quốc nổi tiếng với những sản phẩm xe 2 cầu. Đồng thời, hãng xe này còn quan tâm đến môi trường, nên các mẫu xe sản xuất ra đều có khả năng tái chế đến 85% trở lên.', 1, '2022-12-16 03:23:22', '2022-12-15 20:23:22'),
(7, 'ROLLS-ROYCE', 'Rolls-Royce có trụ sở tại Goodwood – Anh, năm 1904 chiếc xe Rolls-Royce đầu tiên được ra mắt bởi Frederick Royce. Đến năm 1998, công ty này được công ty  Volkswagen – Đức mua lại.', 1, '2022-12-16 03:23:34', '2022-12-15 20:23:34'),
(8, 'FORD', 'Hãng xe Ford được thành lập năm 1903 do Henry Ford sáng lập, thuộc công ty mẹ là Ford Motor Company, có trụ sở chính tại Dearborn, Michigan nước Mỹ.', 1, '2022-12-16 03:23:52', '2022-12-15 20:23:52'),
(9, 'CADILLAC', 'Cadillac được xây dựng từ tiền thân Công ty Henry Ford vào năm 1902 trước khi xuất hiện Chevrolet 9 năm.', 1, '2022-12-16 03:24:16', '2022-12-15 20:24:16'),
(10, 'MERCEDES - BENZ', 'Được mệnh danh là “linh hồn của nước Đức”, Mercedes-Benz là một trong những dòng xe sang chảnh và đẳng cấp nhất trên thế giới, có nguồn gốc từ Đức.', 1, '2022-12-16 03:24:33', '2022-12-15 20:24:33'),
(11, 'AUDI', 'Hãng xe Audi có trụ sở chính được đặt ở Ingolstadt, Đức và là một trong những công ty con của tập đoàn ô tô hùng mạnh Volkswagen AG.', 1, '2022-12-16 03:24:47', '2022-12-15 20:24:47'),
(12, 'BMW', 'BMW là tên viết tắt của Bayerische Motoren Werke AG. Với hơn 100 năm hình thành và phát triển, BMW thực sự đã khẳng định được vị thế của mình trên thị trường xe hơi quốc tế. Ra đời vào ngày 07/3/1916, không lâu sau đó BMW trở thành thương hiệu thứ 3 trong top 10 thương hiệu xe hơi giá trị nhất thế giới.', 1, '2022-12-16 03:25:03', '2022-12-15 20:25:03'),
(13, 'VOLKSWAGEN', 'Volkswagen thuộc top những hãng xe hơi nổi tiếng trên thế giới với việc phát triển các dòng xe hạng sang khắp các thị trường từ Châu Âu cho đến Bắc Mỹ. Tính đến thời điểm hiện tại, hãng đã bán ra trên thị trường với số lượng hơn 8,5 triệu chiếc.', 1, '2022-12-16 03:25:18', '2023-02-15 08:49:26');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_car`
--

CREATE TABLE `tbl_car` (
  `id` int(11) NOT NULL,
  `car_name` varchar(50) NOT NULL,
  `car_desc` text NOT NULL,
  `brand_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `car_price` varchar(50) DEFAULT NULL,
  `car_img` varchar(50) DEFAULT NULL,
  `car_status` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_car`
--

INSERT INTO `tbl_car` (`id`, `car_name`, `car_desc`, `brand_id`, `category_id`, `car_price`, `car_img`, `car_status`, `created_at`, `updated_at`) VALUES
(5, 'Xe kia mới', '<p>Xe mới qua xử dụng</p>', 2, 7, '450000', 'hang-oto-kia43.jpg', 1, '2022-12-16 03:31:00', '2022-12-15 20:31:00'),
(6, 'Siêu xe mới', '<p>Xe BMW sang trọng</p>', 12, 6, '1200000', 'hang-xe-bmw38.jpg', 1, '2022-12-16 03:32:05', '2022-12-15 20:32:05'),
(7, 'Xe cho thuê 7 chỗ', '<p>Xe rộng r&atilde;i cho gia đ&igrave;nh</p>', 1, 5, '500000', 'hang-o-to-huyndai7.jpg', 1, '2022-12-16 03:33:45', '2022-12-15 20:33:45'),
(8, 'Xe dự tiệc', '<p>Xe mới</p>', 7, 6, '2000000', 'hang-xe-rolls-royce41.jpg', 1, '2022-12-16 03:34:21', '2022-12-15 20:34:21');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_car_rental`
--

CREATE TABLE `tbl_car_rental` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rental_desc` text NOT NULL,
  `car_id` int(11) NOT NULL,
  `time_start` date NOT NULL,
  `time_end` date NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_car_rental`
--

INSERT INTO `tbl_car_rental` (`id`, `user_id`, `rental_desc`, `car_id`, `time_start`, `time_end`, `created_at`, `updated_at`) VALUES
(1, 1, '1', 5, '2023-03-11', '2023-03-13', '2022-12-05 05:20:04', '2022-12-05 05:20:04');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_category`
--

CREATE TABLE `tbl_category` (
  `id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  `category_desc` text NOT NULL,
  `category_status` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_category`
--

INSERT INTO `tbl_category` (`id`, `category_name`, `category_desc`, `category_status`, `created_at`, `updated_at`) VALUES
(1, 'Xe 4 chỗ', 'xe có 4 chỗ ngồi.', 1, '2022-12-05 05:34:15', '2022-12-16 03:26:05'),
(2, 'Xe 7 chỗ', 'Xe có 7 chỗ ngồi.', 1, '2022-12-16 03:26:26', '2022-12-15 20:26:26'),
(3, 'Xe điện', 'Xe chạy bằng điện', 1, '2022-12-16 03:26:40', '2022-12-15 20:26:40'),
(4, 'Xe số sàn', 'Xe chạy số sàn', 1, '2022-12-16 03:27:09', '2022-12-15 20:27:09'),
(5, 'Xe số tự động', 'Xe số tự động', 1, '2022-12-16 03:27:25', '2022-12-15 20:27:25'),
(6, 'Xe cao cấp', 'Xe cao cấp', 1, '2022-12-16 03:27:54', '2022-12-15 20:27:54'),
(7, 'Xe bình dân', 'Xe bình dân', 1, '2022-12-16 03:28:08', '2023-02-15 08:39:11'),
(8, 'Vinfast', 'Đẹp', 0, '2023-02-27 18:35:53', '2023-02-27 11:35:53');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `name`, `email`, `phone`, `address`, `password`, `role`, `status`, `created_at`, `updated_at`) VALUES
(1, 'admin', 'hovandai2406@gmail.com', '0359689876', 'Ha Noi', '$2a$10$RAqHTe/MNp.oQVy2kyWETOG1vjUMVFn94DTXyaF2D9s', 'ADMIN', 'active', '2023-04-01 18:17:19', NULL),
(3, 'XuanAnh', 'xanh@gmail.com', '0366046334', 'Tây Mỗ, Nam Từ Liêm, Hà Nội', '$2a$10$RAqHTe/MNp.oQVy2kyWETOG1vjUMVFn94DTXyaF2D9s', 'ADMIN', 'active', '2023-04-01 18:17:19', NULL),
(4, 'ducthang1', 'thangnguyen1032000@gmail.com', '0359689876', 'Ha Noi', '$2a$10$RAqHTe/MNp.oQVy2kyWETOG1vjUMVFn94DTXyaF2D9s', 'USER', 'active', '2023-04-01 18:17:19', NULL),
(5, 'thang2', 'thang1@yopmail.com', '', '', '$2a$10$5MpGJd22kXyhutSStXYmJOJ2CwKRcMP1Xs9PUIKpFezf8Kg1qjNMe', 'USER', 'active', '2023-04-10 18:21:11', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_brand`
--
ALTER TABLE `tbl_brand`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_car`
--
ALTER TABLE `tbl_car`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Chỉ mục cho bảng `tbl_car_rental`
--
ALTER TABLE `tbl_car_rental`
  ADD PRIMARY KEY (`id`),
  ADD KEY `car_id` (`car_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbl_brand`
--
ALTER TABLE `tbl_brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tbl_car`
--
ALTER TABLE `tbl_car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `tbl_car_rental`
--
ALTER TABLE `tbl_car_rental`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tbl_category`
--
ALTER TABLE `tbl_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbl_car`
--
ALTER TABLE `tbl_car`
  ADD CONSTRAINT `tbl_car_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `tbl_brand` (`id`),
  ADD CONSTRAINT `tbl_car_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`);

--
-- Các ràng buộc cho bảng `tbl_car_rental`
--
ALTER TABLE `tbl_car_rental`
  ADD CONSTRAINT `tbl_car_rental_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `tbl_car` (`id`),
  ADD CONSTRAINT `tbl_car_rental_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
