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


INSERT INTO public.books_authors (book_id, author_id) values
(2, 1),
(1, 2),
(3, 3),
(4, 4),
(7, 5),
(5, 6),
(5, 7),
(6, 8),
(9, 9),
(10, 10),
(9, 11),
(13, 12),
(12, 13);


INSERT INTO public.roles ("name") values
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_GUEST');

INSERT INTO public.appuser (id, email, first_name, last_name, "password", status, role_id)values
('23a727ef-d517-4769-af46-a655f057816b', 'firepoint.pro@gmail.com', 'Petrenko', 'Viacheslav', '13', 'ACTIVE', 1);
('0eb3fb83-f121-418f-8aae-d5104b477966', 'RM.Strukov@Ined.ru', 'user', 'user', '13', 'ACTIVE', 2);

INSERT INTO public."comments" (commenttext, user_id, book_id) values
('Не зна, не читал', '0eb3fb83-f121-418f-8aae-d5104b477966', 1),
('Купил, начну читать', '0eb3fb83-f121-418f-8aae-d5104b477966', 1),
('Прочитал, спасибо', '0eb3fb83-f121-418f-8aae-d5104b477966', 1),











