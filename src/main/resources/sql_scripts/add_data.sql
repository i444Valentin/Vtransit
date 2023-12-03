-- Выполните этот скрипт, чтобы добавить данные в базу данных
-- Прежде всего создайте таблицы, выполнив скрипт generate_db.sql

-- Добавление данных о лицензиях водителей

INSERT INTO public.license(
	serial_number, gibdd_number, region, categories)
	VALUES (7414291020, 7711, 'г. Москва', '{"A","B","C"}');

INSERT INTO public.license(
	serial_number, gibdd_number, region, categories)
	VALUES (7414291110, 7711, 'г. Москва', '{"A","B"}');

INSERT INTO public.license(
	serial_number, gibdd_number, region, categories)
	VALUES (7414291130, 7711, 'г. Москва', '{"A","B1","B1E"}');

-- Добавление данных о водителях

INSERT INTO public.driver(
	id, first_name, last_name, birth_day, gender, license)
	VALUES (default, 'Иванов', 'Петр', '12.15.1992', 'мужской', 7414291020);

INSERT INTO public.driver(
	id, first_name, last_name, birth_day, gender, license)
	VALUES (default, 'Петров', 'Алексей', '12.22.1987', 'мужской', 7414291110);

INSERT INTO public.driver(
	id, first_name, last_name, birth_day, gender, license)
	VALUES (default, 'Алексеев', 'Валерий', '02.11.1992', 'мужской', 7414291130);

--Добавление транспорта

INSERT INTO public.vehicle(
	gos_num_sign, model, vehicle_type, manufactured, servicing)
	VALUES ('A844BO', 'Mercedes EQE 350 Sedan', 'Легковой', '2020', null);

INSERT INTO public.vehicle(
	gos_num_sign, model, vehicle_type, manufactured, servicing)
	VALUES ('K923СВ', 'Mercedes EQE 350 Sedan', 'Легковой', '2020', null),
	('K012TT', 'Mercedes EQE 500+ Sedan', 'Легковой', '2020', null),
	('P850ME', 'Audi Q3', 'Внедорожник', '2017', null);

--Добавление обслуживания ТС
--**Пройденное расстояние указывается в километрах

INSERT INTO public.servicing(
	vehicle_id,traveled, engine_state, transmission_state, common_state, last_service)
	VALUES (4,10000, 'Исправен', 'Исправна', 'Исправен', now());

INSERT INTO public.servicing(
	vehicle_id,traveled, engine_state, transmission_state, common_state, last_service)
	VALUES (6,16000, 'Исправен', 'Исправна', 'Исправен', now());

INSERT INTO public.servicing(
	vehicle_id,traveled, engine_state, transmission_state, common_state, last_service)
	VALUES (7,11050, 'Исправен', 'Необходимо обслужить', 'Исправен', now());

INSERT INTO public.servicing(
	vehicle_id,traveled, engine_state, transmission_state, common_state, last_service)
	VALUES (8,432000, 'Исправен', 'Неисправна', 'Неисправен', now());

--Добавление адресов

INSERT INTO public.address(
	id, city, region, area, street, house, apartment)
	VALUES (default, 'г. Пенза', null, 'Ленинский р-н', 'ул.Суровора', '130a', '10');

INSERT INTO public.address(
	id, city, region, area, street, house, apartment)
	VALUES (default, 'г. Пенза', 'Пензенская область', 'Ленинский р-н', 'ул.Суровора', '130a', '10');

INSERT INTO public.address(
	id, city, region, area, street, house, apartment)
	VALUES (default, 'г. Пенза', null, 'Ленинский р-н', 'ул.Пушкина', '120', null);

INSERT INTO public.address(
	id, city, region, area, street, house, apartment)
	VALUES (default, null, 'Пензенская область', 'Белинский район', 'ул.Советская', '45', null);

--Добавление маршрутов
--**Расстояние указано в километрах

INSERT INTO public.route(
	route_id, departure, destination, distance)
	VALUES (default, 6, 3, 37);


--добавление данных для таблицы Поездки

INSERT INTO public.travel(
	travel_number, vehicle, driver, route, task_description, started, finished, travel_date)
	VALUES (1, 6, 7, 1, 'Доставка товара "Набор посуды, стекло, керамика EMAX"', now(), null, now());

--добавление данных оплаты
--**Расчет идет за часы и за километры

INSERT INTO public.payment(
	travel_number, time_count, travelled, bonus, tariff_time, tariff_distance)
	VALUES (1, '01:00', 80, 500, 100, 12);