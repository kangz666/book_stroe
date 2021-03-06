USE [book_stroe]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 07/03/2020 19:39:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[username] [nchar](10) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[name] [nchar](10) NOT NULL,
	[iphonenumber] [nvarchar](50) NOT NULL,
	[address] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Users] ([username], [password], [name], [iphonenumber], [address]) VALUES (N'111       ', N'444', N'55        ', N'66', N'8888')
/****** Object:  Table [dbo].[shop_cart]    Script Date: 07/03/2020 19:39:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shop_cart](
	[shop_no] [bigint] IDENTITY(1,1) NOT NULL,
	[shop_id] [nvarchar](50) NOT NULL,
	[book_id] [nvarchar](50) NOT NULL,
	[book_name] [nvarchar](50) NOT NULL,
	[order_sum] [nvarchar](50) NOT NULL,
	[book_price] [float] NOT NULL,
 CONSTRAINT [PK_shop_cart] PRIMARY KEY CLUSTERED 
(
	[shop_no] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[shop_cart] ON
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (2, N'2018900', N'1004', N'红楼梦', N'1', 9.9)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (3, N'2018900', N'1009', N'java编程思想', N'1', 98.9)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (18, N'test', N'1001', N'西游记', N'56', 524092.79999999993)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (37, N'111', N'1001', N'西游记', N'89', 6108176.8)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (38, N'111', N'1009', N'java编程思想', N'1', 98.99)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (39, N'test', N'10041', N'红楼梦1', N'1', 19.9)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (40, N'test', N'20089', N'策略思维9', N'1', 114.9)
INSERT [dbo].[shop_cart] ([shop_no], [shop_id], [book_id], [book_name], [order_sum], [book_price]) VALUES (41, N'111', N'10048', N'红楼梦8', N'1', 89.9)
SET IDENTITY_INSERT [dbo].[shop_cart] OFF
/****** Object:  Table [dbo].[Orders]    Script Date: 07/03/2020 19:39:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[order_id] [nvarchar](50) NOT NULL,
	[book_id] [nvarchar](50) NOT NULL,
	[manager_id] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[book_name] [nvarchar](50) NOT NULL,
	[order_sum] [nvarchar](50) NOT NULL,
	[date] [datetime] NULL,
	[name] [nvarchar](50) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[phonenumber] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[order_state] [nvarchar](50) NOT NULL,
	[order_remark] [nvarchar](max) NULL,
 CONSTRAINT [PK_order] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'001115465', N'62656', N'564654646', N'5656464654', N'645646', N'54654', CAST(0x0000ABEA00000000 AS DateTime), N'465', N'546', N'4154', 5646, N'56465', N'465')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'001323215465', N'6245656', N'123', N'56564564654', N'645646', N'54654', CAST(0x0000ABEA00000000 AS DateTime), N'465', N'546', N'4154', 5646, N'是', N'465')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593565679781', N'1004', N'abc123', N'111       ', N'红楼梦', N'5', CAST(0x0000ABEB00000000 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 1198.8, N'已退款', N'如：卖家是最好的！')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593570395105', N'1005', N'abc123', N'111       ', N'三国演义', N'1', CAST(0x0000ABEB00000000 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 99.99, N'已退款', N'不喜欢了，我就是三分钟热度')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593570416715', N'1004', N'abc123', N'111       ', N'红楼梦', N'5', CAST(0x0000ABEB00000000 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 1198.8, N'拒绝退款', N'不喜欢了，我就是三分钟热度')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593570802145', N'1005', N'  ', N'111       ', N'三国演义', N'1', CAST(0x0000ABEB00000000 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 99.99, N'退款', N'卖家是最好的！')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593589700599', N'1234', N' ', N'111       ', N'笑傲江湖', N'101', CAST(0x0000ABEB00000000 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 8968.8, N'未处理', N'卖家是最好的！')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593589842326', N'1009', N'abc123', N'111       ', N'java编程思想', N'1', CAST(0x0000ABEB00000000 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 98.99, N'已发货', N'卖家是最好的！')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593591978280', N'8520', N'abc123', N'111       ', N'计算机网络', N'8', CAST(0x0000ABEB010EE5AE AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 3196, N'拒绝退款', N'不喜欢了，我就是三分钟热度')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593595602758', N'1004', N'abc123', N'111       ', N'红楼梦', N'5', CAST(0x0000ABEB011F7D20 AS DateTime), N'55 爬爬爬    ', N'8888', N'66', 1198.8, N'已断货', N'卖家是最好的！')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593615733601', N'1004', N'abc123', N'111       ', N'红楼梦', N'22', CAST(0x0000ABEB017BA3F3 AS DateTime), N'55        ', N'8888', N'66', 4395.6, N'已退款', N'不喜欢了，我就是三分钟热度')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593656225574', N'1001', N'abc123', N'111       ', N'西游记', N'1', CAST(0x0000ABEC00A97D59 AS DateTime), N'55        ', N'8888', N'66', 779.9, N'已断货', N'卖家是最好的！')
INSERT [dbo].[Orders] ([order_id], [book_id], [manager_id], [username], [book_name], [order_sum], [date], [name], [address], [phonenumber], [price], [order_state], [order_remark]) VALUES (N'1593656232685', N'1004', N'abc123', N'111       ', N'红楼梦', N'1', CAST(0x0000ABEC00A985AE AS DateTime), N'55        ', N'8888', N'66', 9.99, N'已发货', N'卖家是最好的！')
/****** Object:  Table [dbo].[Manager]    Script Date: 07/03/2020 19:39:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[manager_id] [nchar](10) NOT NULL,
	[manager_password] [nvarchar](50) NOT NULL,
	[manager_phonenumber] [nvarchar](50) NOT NULL,
	[manager_email] [nvarchar](max) NULL,
 CONSTRAINT [PK_Manager] PRIMARY KEY CLUSTERED 
(
	[manager_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Manager] ([manager_id], [manager_password], [manager_phonenumber], [manager_email]) VALUES (N'abc123    ', N'8888', N'123456789', N'895623@qq.com')
INSERT [dbo].[Manager] ([manager_id], [manager_password], [manager_phonenumber], [manager_email]) VALUES (N'admin     ', N'admin', N'12223555', N'52845455@qq.com')
/****** Object:  Table [dbo].[book_info]    Script Date: 07/03/2020 19:39:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book_info](
	[book_id] [nvarchar](50) NOT NULL,
	[book_name] [nvarchar](50) NOT NULL,
	[book_auther] [nvarchar](50) NOT NULL,
	[book_price] [float] NOT NULL,
	[book_type] [nvarchar](50) NOT NULL,
	[book_introdution] [nvarchar](max) NULL,
 CONSTRAINT [PK_book_info] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'1001', N'西游记', N'吴承恩', 779.9, N'玄幻', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'1004', N'红楼梦', N'曹雪芹', 9.99, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10041', N'红楼梦1', N'曹雪芹', 19.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10042', N'红楼梦2', N'曹雪芹', 29.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10043', N'红楼梦3', N'曹雪芹', 39.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10044', N'红楼梦4', N'曹雪芹', 49.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10045', N'红楼梦5', N'曹雪芹', 59.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10046', N'红楼梦6', N'曹雪芹', 69.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10047', N'红楼梦7', N'曹雪芹', 79.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10048', N'红楼梦8', N'曹雪芹', 89.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10049', N'红楼梦9', N'曹雪芹', 99.9, N'言情', N'四大名著，经典藏书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'1005', N'三国演义', N'罗贯中', 99.99, N'军事', N'四大名著，军事经典')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'1009', N'java编程思想', N'埃克尔', 98.99, N'学习', N'经典图书，深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10091', N'java编程思想1', N'埃克尔', 103.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10092', N'java编程思想2', N'埃克尔', 108.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10093', N'java编程思想3', N'埃克尔', 113.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10094', N'java编程思想4', N'埃克尔', 118.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10095', N'java编程思想5', N'埃克尔', 123.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10096', N'java编程思想6', N'埃克尔', 128.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10097', N'java编程思想7', N'埃克尔', 133.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10098', N'java编程思想8', N'埃克尔', 138.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'10099', N'java编程思想9', N'埃克尔', 143.9, N'学习', N'经典图书,深入学习编程思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'1100', N'射雕英雄传', N'金庸', 59.6, N'武侠', N'是甜甜的恋爱')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'1234', N'笑傲江湖', N'金庸', 88.8, N'武侠', N'江湖武林，各派纷争')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20001', N'简爱1', N'夏洛蒂·勃朗', 74.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20002', N'简爱2', N'夏洛蒂·勃朗', 79.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20003', N'简爱3', N'夏洛蒂·勃朗', 84.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20004', N'简爱4', N'夏洛蒂·勃朗', 89.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20005', N'简爱5', N'夏洛蒂·勃朗', 94.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20006', N'简爱6', N'夏洛蒂·勃朗', 99.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20007', N'简爱7', N'夏洛蒂·勃朗', 104.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20008', N'简爱8', N'夏洛蒂·勃朗', 109.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20009', N'简爱9', N'夏洛蒂·勃朗', 114.9, N'小说', N'主人公善良牺牲崇敬，女主人公真爱不所求')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20011', N'活出生命的意义1', N'维克多·弗兰克', 114.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20012', N'活出生命的意义2', N'维克多·弗兰克', 119.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20013', N'活出生命的意义3', N'维克多·弗兰克', 124.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20014', N'活出生命的意义4', N'维克多·弗兰克', 129.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20015', N'活出生命的意义5', N'维克多·弗兰克', 134.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20016', N'活出生命的意义6', N'维克多·弗兰克', 139.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20017', N'活出生命的意义7', N'维克多·弗兰克', 144.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20018', N'活出生命的意义8', N'维克多·弗兰克', 149.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20019', N'活出生命的意义9', N'维克多·弗兰克', 154.9, N'小说', N'纳粹时期，作为犹太人，他的全家都被关进了...')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20021', N'拖延心理学1', N'简·博克 ', 124.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20022', N'拖延心理学2', N'简·博克 ', 129.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20023', N'拖延心理学3', N'简·博克 ', 134.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20024', N'拖延心理学4', N'简·博克 ', 139.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20025', N'拖延心理学5', N'简·博克 ', 144.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20026', N'拖延心理学6', N'简·博克 ', 149.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20027', N'拖延心理学7', N'简·博克 ', 154.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20028', N'拖延心理学8', N'简·博克 ', 159.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20029', N'拖延心理学9', N'简·博克 ', 164.9, N'文学', N'你想要向拖延的恶习开刀吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20031', N'梦的解析1', N'弗洛伊德 ', 94.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20032', N'梦的解析2', N'弗洛伊德 ', 99.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20033', N'梦的解析3', N'弗洛伊德 ', 104.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20034', N'梦的解析4', N'弗洛伊德 ', 109.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20035', N'梦的解析5', N'弗洛伊德 ', 114.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20036', N'梦的解析6', N'弗洛伊德 ', 119.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20037', N'梦的解析7', N'弗洛伊德 ', 124.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20038', N'梦的解析8', N'弗洛伊德 ', 129.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20039', N'梦的解析9', N'弗洛伊德 ', 134.9, N'文学', N'被誉为精神分析第一名著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20041', N'如何阅读一本书1', N'查尔斯·范多伦 ', 64.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20042', N'如何阅读一本书2', N'查尔斯·范多伦 ', 69.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20043', N'如何阅读一本书3', N'查尔斯·范多伦 ', 74.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20044', N'如何阅读一本书4', N'查尔斯·范多伦 ', 79.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20045', N'如何阅读一本书5', N'查尔斯·范多伦 ', 84.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20046', N'如何阅读一本书6', N'查尔斯·范多伦 ', 89.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20047', N'如何阅读一本书7', N'查尔斯·范多伦 ', 94.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20048', N'如何阅读一本书8', N'查尔斯·范多伦 ', 99.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20049', N'如何阅读一本书9', N'查尔斯·范多伦 ', 104.9, N'文学', N'不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20051', N'影响力1', N'罗伯特·西奥迪尼 ', 94.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20052', N'影响力2', N'罗伯特·西奥迪尼 ', 99.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20053', N'影响力3', N'罗伯特·西奥迪尼 ', 104.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20054', N'影响力4', N'罗伯特·西奥迪尼 ', 109.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20055', N'影响力5', N'罗伯特·西奥迪尼 ', 114.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20056', N'影响力6', N'罗伯特·西奥迪尼 ', 119.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20057', N'影响力7', N'罗伯特·西奥迪尼 ', 124.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20058', N'影响力8', N'罗伯特·西奥迪尼 ', 129.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20059', N'影响力9', N'罗伯特·西奥迪尼 ', 134.9, N'知识', N'政治家运用影响力来赢得选举')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20061', N'设计心理学1', N'唐纳德·A·诺曼', 44.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20062', N'设计心理学2', N'唐纳德·A·诺曼', 49.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20063', N'设计心理学3', N'唐纳德·A·诺曼', 54.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20064', N'设计心理学4', N'唐纳德·A·诺曼', 59.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20065', N'设计心理学5', N'唐纳德·A·诺曼', 64.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20066', N'设计心理学6', N'唐纳德·A·诺曼', 69.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20067', N'设计心理学7', N'唐纳德·A·诺曼', 74.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20068', N'设计心理学8', N'唐纳德·A·诺曼', 79.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20069', N'设计心理学9', N'唐纳德·A·诺曼', 84.9, N'知识', N'本书是对产品设计感兴趣同学的必读书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20071', N'小王子1', N'安东尼·德', 94.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20072', N'小王子2', N'安东尼·德', 99.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20073', N'小王子3', N'安东尼·德', 104.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20074', N'小王子4', N'安东尼·德', 109.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20075', N'小王子5', N'安东尼·德', 114.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20076', N'小王子6', N'安东尼·德', 119.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20077', N'小王子7', N'安东尼·德', 124.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20078', N'小王子8', N'安东尼·德', 129.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20079', N'小王子9', N'安东尼·德', 134.9, N'知识', N'圣埃克苏佩里是一个传奇飞行家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20081', N'策略思维1', N'阿维纳什', 74.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20082', N'策略思维2', N'阿维纳什', 79.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20083', N'策略思维3', N'阿维纳什', 84.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20084', N'策略思维4', N'阿维纳什', 89.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20085', N'策略思维5', N'阿维纳什', 94.9, N'知识', N'展示了博弈论策略思维的道理')
GO
print 'Processed 100 total records'
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20086', N'策略思维6', N'阿维纳什', 99.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20087', N'策略思维7', N'阿维纳什', 104.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20088', N'策略思维8', N'阿维纳什', 109.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20089', N'策略思维9', N'阿维纳什', 114.9, N'知识', N'展示了博弈论策略思维的道理')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20091', N'无价1', N'威廉·庞德斯通', 74.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20092', N'无价2', N'威廉·庞德斯通', 79.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20093', N'无价3', N'威廉·庞德斯通', 84.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20094', N'无价4', N'威廉·庞德斯通', 89.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20095', N'无价5', N'威廉·庞德斯通', 94.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20096', N'无价6', N'威廉·庞德斯通', 99.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20097', N'无价7', N'威廉·庞德斯通', 104.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20098', N'无价8', N'威廉·庞德斯通', 109.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20099', N'无价9', N'威廉·庞德斯通', 114.9, N'知识', N'为什么免费的巧克力让我们疯狂')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20101', N'浅薄1', N'尼古拉斯·卡尔', 74.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20102', N'浅薄2', N'尼古拉斯·卡尔', 79.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20103', N'浅薄3', N'尼古拉斯·卡尔', 84.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20104', N'浅薄4', N'尼古拉斯·卡尔', 89.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20105', N'浅薄5', N'尼古拉斯·卡尔', 94.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20106', N'浅薄6', N'尼古拉斯·卡尔', 99.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20107', N'浅薄7', N'尼古拉斯·卡尔', 104.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20108', N'浅薄8', N'尼古拉斯·卡尔', 109.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20109', N'浅薄9', N'尼古拉斯·卡尔', 114.9, N'知识', N'谷歌在把我们变傻吗？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20111', N'定位1', N'艾·里斯', 74.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20112', N'定位2', N'艾·里斯', 79.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20113', N'定位3', N'艾·里斯', 84.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20114', N'定位4', N'艾·里斯', 89.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20115', N'定位5', N'艾·里斯', 94.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20116', N'定位6', N'艾·里斯', 99.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20117', N'定位7', N'艾·里斯', 104.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20118', N'定位8', N'艾·里斯', 109.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20119', N'定位9', N'艾·里斯', 114.9, N'知识', N'美国《广告时代》杂志约请年轻的营销专家')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20121', N'史记1', N'司马迁', 74.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20122', N'史记2', N'司马迁', 79.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20123', N'史记3', N'司马迁', 84.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20124', N'史记4', N'司马迁', 89.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20125', N'史记5', N'司马迁', 94.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20126', N'史记6', N'司马迁', 99.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20127', N'史记7', N'司马迁', 104.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20128', N'史记8', N'司马迁', 109.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20129', N'史记9', N'司马迁', 114.9, N'知识', N'《史记》是一本丰富多彩的生动的人物画卷')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20131', N'社会契约论1', N'卢梭', 93.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20132', N'社会契约论2', N'卢梭', 98.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20133', N'社会契约论3', N'卢梭', 103.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20134', N'社会契约论4', N'卢梭', 108.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20135', N'社会契约论5', N'卢梭', 113.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20136', N'社会契约论6', N'卢梭', 118.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20137', N'社会契约论7', N'卢梭', 123.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20138', N'社会契约论8', N'卢梭', 128.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20139', N'社会契约论9', N'卢梭', 133.9, N'知识', N'主权在民的思想')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20141', N'目送1', N'龙应台', 83.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20142', N'目送2', N'龙应台', 88.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20143', N'目送3', N'龙应台', 93.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20144', N'目送4', N'龙应台', 98.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20145', N'目送5', N'龙应台', 103.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20146', N'目送6', N'龙应台', 108.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20147', N'目送7', N'龙应台', 113.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20148', N'目送8', N'龙应台', 118.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20149', N'目送9', N'龙应台', 123.9, N'知识', N'一本极具亲情、感人至深的文集')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20151', N'欢乐的经济学1', N'戴维·亨德森', 80.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20152', N'欢乐的经济学2', N'戴维·亨德森', 85.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20153', N'欢乐的经济学3', N'戴维·亨德森', 90.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20154', N'欢乐的经济学4', N'戴维·亨德森', 95.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20155', N'欢乐的经济学5', N'戴维·亨德森', 100.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20156', N'欢乐的经济学6', N'戴维·亨德森', 105.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20157', N'欢乐的经济学7', N'戴维·亨德森', 110.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20158', N'欢乐的经济学8', N'戴维·亨德森', 115.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20159', N'欢乐的经济学9', N'戴维·亨德森', 120.9, N'知识', N'普及经济学思维、传达自由至上理念的书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20161', N'19841', N'乔治奥威尔', 80.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20162', N'19842', N'乔治奥威尔', 85.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20163', N'19843', N'乔治奥威尔', 90.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20164', N'19844', N'乔治奥威尔', 95.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20165', N'19845', N'乔治奥威尔', 100.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20166', N'19846', N'乔治奥威尔', 105.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20167', N'19847', N'乔治奥威尔', 110.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20168', N'19848', N'乔治奥威尔', 115.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20169', N'19849', N'乔治奥威尔', 120.9, N'小说', N'作品刻画了人类在极权主义社会的生存状态')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20171', N'孙子兵法1', N'孙武', 80.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20172', N'孙子兵法2', N'孙武', 85.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20173', N'孙子兵法3', N'孙武', 90.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20174', N'孙子兵法4', N'孙武', 95.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20175', N'孙子兵法5', N'孙武', 100.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20176', N'孙子兵法6', N'孙武', 105.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20177', N'孙子兵法7', N'孙武', 110.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20178', N'孙子兵法8', N'孙武', 115.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20179', N'孙子兵法9', N'孙武', 120.9, N'军事', N'中国古典军事文化遗产')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20181', N'Facebook效应1', N'大卫·柯克帕特里克', 80.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20182', N'Facebook效应2', N'大卫·柯克帕特里克', 85.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20183', N'Facebook效应3', N'大卫·柯克帕特里克', 90.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20184', N'Facebook效应4', N'大卫·柯克帕特里克', 95.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20185', N'Facebook效应5', N'大卫·柯克帕特里克', 100.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20186', N'Facebook效应6', N'大卫·柯克帕特里克', 105.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20187', N'Facebook效应7', N'大卫·柯克帕特里克', 110.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20188', N'Facebook效应8', N'大卫·柯克帕特里克', 115.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20189', N'Facebook效应9', N'大卫·柯克帕特里克', 120.9, N'知识', N'该书值得所有希望了解互联网和新媒体的同学深入了解')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20191', N'资本论1', N'马克思', 110.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20192', N'资本论2', N'马克思', 115.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20193', N'资本论3', N'马克思', 120.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20194', N'资本论4', N'马克思', 125.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20195', N'资本论5', N'马克思', 130.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20196', N'资本论6', N'马克思', 135.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20197', N'资本论7', N'马克思', 140.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
GO
print 'Processed 200 total records'
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20198', N'资本论8', N'马克思', 145.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20199', N'资本论9', N'马克思', 150.9, N'知识', N'该书是马克思用毕生的心血写成的一部光辉灿烂的科学巨著')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20201', N'山海经1', N'先秦古人', 110.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20202', N'山海经2', N'先秦古人', 115.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20203', N'山海经3', N'先秦古人', 120.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20204', N'山海经4', N'先秦古人', 125.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20205', N'山海经5', N'先秦古人', 130.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20206', N'山海经6', N'先秦古人', 135.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20207', N'山海经7', N'先秦古人', 140.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20208', N'山海经8', N'先秦古人', 145.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20209', N'山海经9', N'先秦古人', 150.9, N'传说', N'富于神话传说的最古老的地理书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20211', N'牛奶可乐经济学1', N'罗伯特·弗兰克', 110.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20212', N'牛奶可乐经济学2', N'罗伯特·弗兰克', 115.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20213', N'牛奶可乐经济学3', N'罗伯特·弗兰克', 120.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20214', N'牛奶可乐经济学4', N'罗伯特·弗兰克', 125.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20215', N'牛奶可乐经济学5', N'罗伯特·弗兰克', 130.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20216', N'牛奶可乐经济学6', N'罗伯特·弗兰克', 135.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20217', N'牛奶可乐经济学7', N'罗伯特·弗兰克', 140.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20218', N'牛奶可乐经济学8', N'罗伯特·弗兰克', 145.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20219', N'牛奶可乐经济学9', N'罗伯特·弗兰克', 150.9, N'经济', N'为什么牛奶装在方盒子里卖，可乐却装在圆瓶子里卖？')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20221', N'老人与海1', N'海明威', 120.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20222', N'老人与海2', N'海明威', 125.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20223', N'老人与海3', N'海明威', 130.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20224', N'老人与海4', N'海明威', 135.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20225', N'老人与海5', N'海明威', 140.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20226', N'老人与海6', N'海明威', 145.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20227', N'老人与海7', N'海明威', 150.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20228', N'老人与海8', N'海明威', 155.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20229', N'老人与海9', N'海明威', 160.9, N'小说', N'围绕着老年渔夫与马林鱼在离岸很远的湾流中搏斗的故事')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20231', N'国富论1', N'亚当·斯密', 60.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20232', N'国富论2', N'亚当·斯密', 65.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20233', N'国富论3', N'亚当·斯密', 70.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20234', N'国富论4', N'亚当·斯密', 75.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20235', N'国富论5', N'亚当·斯密', 80.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20236', N'国富论6', N'亚当·斯密', 85.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20237', N'国富论7', N'亚当·斯密', 90.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20238', N'国富论8', N'亚当·斯密', 95.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20239', N'国富论9', N'亚当·斯密', 100.9, N'经济', N'现代政治经济学研究的起点')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20241', N'百年孤独1', N'加西亚马尔克斯', 110.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20242', N'百年孤独2', N'加西亚马尔克斯', 115.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20243', N'百年孤独3', N'加西亚马尔克斯', 120.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20244', N'百年孤独4', N'加西亚马尔克斯', 125.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20245', N'百年孤独5', N'加西亚马尔克斯', 130.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20246', N'百年孤独6', N'加西亚马尔克斯', 135.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20247', N'百年孤独7', N'加西亚马尔克斯', 140.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20248', N'百年孤独8', N'加西亚马尔克斯', 145.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20249', N'百年孤独9', N'加西亚马尔克斯', 150.9, N'小说', N'魔幻现实主义文学的代表作')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20251', N'玩偶之家1', N'易卜生', 110.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20252', N'玩偶之家2', N'易卜生', 115.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20253', N'玩偶之家3', N'易卜生', 120.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20254', N'玩偶之家4', N'易卜生', 125.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20255', N'玩偶之家5', N'易卜生', 130.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20256', N'玩偶之家6', N'易卜生', 135.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20257', N'玩偶之家7', N'易卜生', 140.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20258', N'玩偶之家8', N'易卜生', 145.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20259', N'玩偶之家9', N'易卜生', 150.9, N'小说', N'易卜生高超的戏剧创作手法也在这部著作中得到体现')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20261', N'资治通鉴1', N'司马光', 110.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20262', N'资治通鉴2', N'司马光', 115.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20263', N'资治通鉴3', N'司马光', 120.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20264', N'资治通鉴4', N'司马光', 125.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20265', N'资治通鉴5', N'司马光', 130.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20266', N'资治通鉴6', N'司马光', 135.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20267', N'资治通鉴7', N'司马光', 140.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20268', N'资治通鉴8', N'司马光', 145.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20269', N'资治通鉴9', N'司马光', 150.9, N'知识', N'描绘了战略至五代期间的历史发展脉络')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20271', N'人性的弱点1', N'戴尔·卡耐基', 110.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20272', N'人性的弱点2', N'戴尔·卡耐基', 115.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20273', N'人性的弱点3', N'戴尔·卡耐基', 120.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20274', N'人性的弱点4', N'戴尔·卡耐基', 125.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20275', N'人性的弱点5', N'戴尔·卡耐基', 130.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20276', N'人性的弱点6', N'戴尔·卡耐基', 135.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20277', N'人性的弱点7', N'戴尔·卡耐基', 140.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20278', N'人性的弱点8', N'戴尔·卡耐基', 145.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20279', N'人性的弱点9', N'戴尔·卡耐基', 150.9, N'知识', N'世界成功学第一书')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20281', N'悲惨世界1', N'雨果', 90.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20282', N'悲惨世界2', N'雨果', 95.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20283', N'悲惨世界3', N'雨果', 100.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20284', N'悲惨世界4', N'雨果', 105.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20285', N'悲惨世界5', N'雨果', 110.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20286', N'悲惨世界6', N'雨果', 115.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20287', N'悲惨世界7', N'雨果', 120.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20288', N'悲惨世界8', N'雨果', 125.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'20289', N'悲惨世界9', N'雨果', 130.9, N'文学', N'融进了法国的历史、建筑、政治、道德哲学、法律、正义、宗教信仰')
INSERT [dbo].[book_info] ([book_id], [book_name], [book_auther], [book_price], [book_type], [book_introdution]) VALUES (N'8520', N'计算机网络', N'谢希仁', 79.9, N'学习', N'计算机教材')
