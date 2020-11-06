INSERT INTO public.bookstyle ("name") VALUES
('Фантастика'),
('Наука'),
('История'),
('Детектив');


INSERT INTO public.books (description, "name", picture, bookstyle_id) values
('testDescription', 'Путешествия Гулливера', '', 1),
('testDescription', 'Франкенштейн, или Современный Прометей', '', 1),
('testDescription', 'Алиса в стране чудес', '', 1),
('testDescription', 'Двадцать тысяч лье под водой', '', 1),
('testDescription', 'Большой атлас по анатомии', '', 2),
('testDescription', 'Краткая история почти всего на свете', '', 2),
('testDescription', 'Земля. Иллюстрированный атлас', '', 2),
('testDescription', 'Война и мир', '', 3),
('testDescription', 'Царь Иоанн Грозный', '', 3),
('testDescription', 'Столпы земли', '', 3),
('testDescription', 'Яркая ночь', '', 4),
('testDescription', 'Лунный камень', '', 4),
('testDescription', 'Десять негритят', '', 4);

INSERT INTO public.authors (first_name, last_name) values
('Мэри', ' Шелли'),
('Джонатан', 'Свифт'),
('Льюис', 'Кэрролл'),
('Жюль', 'Верн'),
('Майкл', 'Алаби'),
('Чихиро', 'Йокочи'),
('Эльке', 'Льютен-Дреколль'),
('Билл', 'Брайсон'),
('Лев', 'Толстой'),
('Кен', 'Фоллет'),
('Лев', 'Жданов'),
('Агата', 'Кристи'),
('Дороти', 'ли Сэйерс'),
('Уилки', 'Коллинз');


INSERT INTO public.books_authors (author_id, book_id) values
(1, 2),
(2, 1),
(3, 3),
(4, 4),
(5, 7),
(6, 5),
(7, 5),
(8, 6),
(9, 8),
(10, 10),
(11, 9),
(12, 13),
(13, 12),
(14, 11);









