USE [master]
GO
/****** Object:  Database [Biblioteca]    Script Date: 30/11/2021 13:46:04 ******/
CREATE DATABASE [Biblioteca]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Biblioteca', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Biblioteca.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Biblioteca_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Biblioteca_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Biblioteca] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Biblioteca].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Biblioteca] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Biblioteca] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Biblioteca] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Biblioteca] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Biblioteca] SET ARITHABORT OFF 
GO
ALTER DATABASE [Biblioteca] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Biblioteca] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Biblioteca] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Biblioteca] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Biblioteca] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Biblioteca] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Biblioteca] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Biblioteca] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Biblioteca] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Biblioteca] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Biblioteca] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Biblioteca] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Biblioteca] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Biblioteca] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Biblioteca] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Biblioteca] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Biblioteca] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Biblioteca] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Biblioteca] SET  MULTI_USER 
GO
ALTER DATABASE [Biblioteca] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Biblioteca] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Biblioteca] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Biblioteca] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Biblioteca] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Biblioteca] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Biblioteca] SET QUERY_STORE = OFF
GO
USE [Biblioteca]
GO
/****** Object:  Table [dbo].[Libro]    Script Date: 30/11/2021 13:46:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Libro](
	[ASIN] [int] IDENTITY(1,1) NOT NULL,
	[Titulo] [nchar](20) NULL,
	[FechaLanzamiento] [date] NULL,
	[Autor] [int] NULL,
	[Categoria] [int] NULL,
	[Editorial] [nchar](10) NULL,
	[Idioma] [nchar](10) NULL,
	[Paginas] [nchar](10) NULL,
 CONSTRAINT [PK_Libro] PRIMARY KEY CLUSTERED 
(
	[ASIN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[vistaLibro]    Script Date: 30/11/2021 13:46:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[vistaLibro] AS
SELECT *
FROM Libro;
GO
/****** Object:  Table [dbo].[Alquiler]    Script Date: 30/11/2021 13:46:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alquiler](
	[IdAlquiler] [int] IDENTITY(1,1) NOT NULL,
	[IdLector] [nchar](10) NULL,
	[IdLibro] [int] NULL,
	[FechaSalida] [date] NULL,
	[FechaEntrada] [date] NULL,
 CONSTRAINT [PK_Alquiler] PRIMARY KEY CLUSTERED 
(
	[IdAlquiler] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Autor]    Script Date: 30/11/2021 13:46:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Autor](
	[IdAutor] [int] IDENTITY(1,1) NOT NULL,
	[Autor] [nchar](10) NULL,
 CONSTRAINT [PK_Autores] PRIMARY KEY CLUSTERED 
(
	[IdAutor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categoria]    Script Date: 30/11/2021 13:46:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categoria](
	[IdCategoria] [int] NOT NULL,
	[NombreCategoria] [nchar](10) NULL,
 CONSTRAINT [PK_Categorías] PRIMARY KEY CLUSTERED 
(
	[IdCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Alquiler] ON 

INSERT [dbo].[Alquiler] ([IdAlquiler], [IdLector], [IdLibro], [FechaSalida], [FechaEntrada]) VALUES (7, N'gdfgfdg   ', 5, CAST(N'2011-02-10' AS Date), CAST(N'2011-02-10' AS Date))
INSERT [dbo].[Alquiler] ([IdAlquiler], [IdLector], [IdLibro], [FechaSalida], [FechaEntrada]) VALUES (8, N'fgfgh     ', 9, CAST(N'2021-11-29' AS Date), CAST(N'2011-02-10' AS Date))
INSERT [dbo].[Alquiler] ([IdAlquiler], [IdLector], [IdLibro], [FechaSalida], [FechaEntrada]) VALUES (9, N'tyu       ', 10, CAST(N'2021-02-11' AS Date), CAST(N'2021-11-29' AS Date))
INSERT [dbo].[Alquiler] ([IdAlquiler], [IdLector], [IdLibro], [FechaSalida], [FechaEntrada]) VALUES (10, N'sdf       ', 12, CAST(N'2011-02-09' AS Date), CAST(N'2011-02-10' AS Date))
SET IDENTITY_INSERT [dbo].[Alquiler] OFF
GO
SET IDENTITY_INSERT [dbo].[Autor] ON 

INSERT [dbo].[Autor] ([IdAutor], [Autor]) VALUES (1, N'sdfg      ')
SET IDENTITY_INSERT [dbo].[Autor] OFF
GO
INSERT [dbo].[Categoria] ([IdCategoria], [NombreCategoria]) VALUES (1, N'asd       ')
INSERT [dbo].[Categoria] ([IdCategoria], [NombreCategoria]) VALUES (2, N'asd       ')
GO
SET IDENTITY_INSERT [dbo].[Libro] ON 

INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (5, N'pepe                ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'italiano  ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (9, N'Daniel              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'español   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (10, N'Alex                ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'español   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (12, N'Manolo              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'frances   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (13, N'Alejandro           ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'español   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (14, N'Alejandro           ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'español   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (15, N'Alejandro           ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'español   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (16, N'Alejandro           ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (19, N'Dani                ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (20, N'Manu                ', CAST(N'2010-12-02' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (21, N'Alejandra           ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (22, N'Ana                 ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (23, N'María               ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (24, N'Ricardo             ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (25, N'Pepa                ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (26, N'Pepa                ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (27, N'Pepa                ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (28, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (29, N'sfd                 ', CAST(N'2011-02-10' AS Date), 1, 2, N'sdf       ', N'Italiano  ', N'900       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (30, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (31, N'sfd                 ', CAST(N'2011-02-10' AS Date), 1, 2, N'sdf       ', N'Italiano  ', N'900       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (32, N'sfd                 ', CAST(N'2011-02-10' AS Date), 1, 2, N'sdf       ', N'Italiano  ', N'1900      ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (33, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (34, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (35, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (36, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (37, N'Ester               ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (38, N'Pepito              ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (39, N'Ester               ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (40, N'Diego               ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (41, N'Diego               ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (42, N'Federica            ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
INSERT [dbo].[Libro] ([ASIN], [Titulo], [FechaLanzamiento], [Autor], [Categoria], [Editorial], [Idioma], [Paginas]) VALUES (43, N'Federica            ', CAST(N'2011-02-10' AS Date), 1, 1, N'Vicens    ', N'Gallego   ', N'100       ')
SET IDENTITY_INSERT [dbo].[Libro] OFF
GO
ALTER TABLE [dbo].[Alquiler]  WITH CHECK ADD  CONSTRAINT [FK__Alquiler__IdLibr__5165187F] FOREIGN KEY([IdLibro])
REFERENCES [dbo].[Libro] ([ASIN])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Alquiler] CHECK CONSTRAINT [FK__Alquiler__IdLibr__5165187F]
GO
ALTER TABLE [dbo].[Libro]  WITH CHECK ADD  CONSTRAINT [FK__Libro__Autor__4AB81AF0] FOREIGN KEY([Autor])
REFERENCES [dbo].[Autor] ([IdAutor])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Libro] CHECK CONSTRAINT [FK__Libro__Autor__4AB81AF0]
GO
ALTER TABLE [dbo].[Libro]  WITH CHECK ADD  CONSTRAINT [FK__Libro__Categoria__49C3F6B7] FOREIGN KEY([Categoria])
REFERENCES [dbo].[Categoria] ([IdCategoria])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Libro] CHECK CONSTRAINT [FK__Libro__Categoria__49C3F6B7]
GO
/****** Object:  StoredProcedure [dbo].[fechaAlquiler]    Script Date: 30/11/2021 13:46:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[fechaAlquiler] (@FechaLanzamiento DATETIME)
AS 
BEGIN

	SET NOCOUNT ON;
SELECT * 
FROM Alquiler
WHere FechaSalida = @FechaLanzamiento;
END
GO
USE [master]
GO
ALTER DATABASE [Biblioteca] SET  READ_WRITE 
GO
