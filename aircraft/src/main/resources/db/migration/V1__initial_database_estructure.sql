-- TABLAS
create table airport
(
    id       bigint       not null
        primary key,
    city     varchar(255) null,
    codeiata varchar(3)   null,
    country  varchar(255) null,
    name     varchar(255) null
);

create table company
(
    id   bigint       not null
        primary key,
    name varchar(255) null
);

create table crew
(
    id         bigint       not null
        primary key,
    code       varchar(255) null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    position   varchar(255) null,
    company_id bigint       null,
    constraint FK4d7c9r26m80i3uy3t9cbxge87
        foreign key (company_id) references company (id)
);

create table hibernate_sequence
(
    next_val bigint null
);

create table mechanic
(
    id                 bigint       not null
        primary key,
    code               varchar(255) null,
    first_name         varchar(255) null,
    last_name          varchar(255) null,
    incorporation_year int          null,
    training           int          null,
    company_id         bigint       null,
    constraint FKa43ifucpnq9u6b1oxx2uecipa
        foreign key (company_id) references company (id)
);

create table plane
(
    id           bigint       not null
        primary key,
    flight_hours double       null,
    manufacturer varchar(255) null,
    model        varchar(255) null,
    registration varchar(255) null
);

create table flight
(
    id             bigint       not null
        primary key,
    code           varchar(255) null,
    departure_date datetime(6)  null,
    duration       double       null,
    company_id     bigint       null,
    destination_id bigint       null,
    origin_id      bigint       null,
    plane_id       bigint       null,
    constraint FK1gyrukpctenh75dryrx21vhxy
        foreign key (company_id) references company (id),
    constraint FK7p9fvp6d7uh9cgn47uet8a8nb
        foreign key (plane_id) references plane (id),
    constraint FKklo899kk631p8lxbgvj7gxk4x
        foreign key (origin_id) references airport (id),
    constraint FKo0jmov4wa5vdyv74cr93mtovg
        foreign key (destination_id) references airport (id)
);

create table crew_flight
(
    crew_id   bigint not null,
    flight_id bigint not null,
    primary key (crew_id, flight_id),
    constraint FK81gm6l07kchyrgh480tmr5a21
        foreign key (flight_id) references flight (id),
    constraint FKj2cms2qaljf8uuyg77gdr6um
        foreign key (crew_id) references crew (id)
);

create table inspection
(
    id            bigint       not null
        primary key,
    description   varchar(255) null,
    duration      double       null,
    final_date    datetime(6)  null,
    initial_date  datetime(6)  null,
    revision_type varchar(255) null,
    airport_id    bigint       null,
    mechanic_id   bigint       null,
    plane_id      bigint       null,
    constraint FK3qtre0vhxglue2hopmnbkgnjc
        foreign key (mechanic_id) references mechanic (id),
    constraint FKe0ja2u9a74nlpchr9e4ukph24
        foreign key (airport_id) references airport (id),
    constraint FKh1w22om5dpux3vpp1ovs872us
        foreign key (plane_id) references plane (id)
);


-- DATOS
INSERT INTO test.airport (id, city, codeiata, country, name)
VALUES (1, 'Madrid', 'IA1', 'España', 'Barajas');
INSERT INTO test.airport (id, city, codeiata, country, name)
VALUES (2, 'Valladolid', 'IA2', 'España', 'Villanubla');
INSERT INTO test.airport (id, city, codeiata, country, name)
VALUES (3, 'Londres', 'IA3', 'Inglaterra', 'Gatwick');

INSERT INTO test.plane (id, flight_hours, manufacturer, model, registration)
VALUES (4, 250.24, 'Boeing', '747', 'N1000A1');
INSERT INTO test.plane (id, flight_hours, manufacturer, model, registration)
VALUES (5, 12.87, 'Airbus', '350', 'N1000A2');
INSERT INTO test.plane (id, flight_hours, manufacturer, model, registration)
VALUES (6, 9530.61, 'Boeing', '777', 'N1000A3');

INSERT INTO test.company (id, name)
VALUES (7, 'Iberia');
INSERT INTO test.company (id, name)
VALUES (8, 'Reparaciones Paco');
INSERT INTO test.company (id, name)
VALUES (9, 'American Airlines');

INSERT INTO test.mechanic (id, code, first_name, last_name, incorporation_year, training,
                           company_id)
VALUES (10, 'MEC001', 'Pablo', 'Marbán', 2017, 0, 7);
INSERT INTO test.mechanic (id, code, first_name, last_name, incorporation_year, training,
                           company_id)
VALUES (11, 'MEC002', 'Luis', 'Calvo', 2015, 1, 8);
INSERT INTO test.mechanic (id, code, first_name, last_name, incorporation_year, training,
                           company_id)
VALUES (12, 'MEC003', 'Francisco', 'Moreno', 2017, 2, 9);
INSERT INTO test.mechanic (id, code, first_name, last_name, incorporation_year, training,
                           company_id)
VALUES (13, 'MEC004', 'Pedro', 'Martínez', 2017, 2, 7);
INSERT INTO test.mechanic (id, code, first_name, last_name, incorporation_year, training,
                           company_id)
VALUES (14, 'MEC005', 'Jesús', 'Navarro', 2017, 2, 7);

INSERT INTO test.crew (id, code, first_name, last_name, position, company_id)
VALUES (16, 'COD001', 'Juan Carlos', 'Blázquez', 'CO_PILOT', 7);
INSERT INTO test.crew (id, code, first_name, last_name, position, company_id)
VALUES (17, 'COD004', 'Antonio', 'Velasco', 'COMMANDER', 7);
INSERT INTO test.crew (id, code, first_name, last_name, position, company_id)
VALUES (18, 'COD005', 'José', 'López', 'COMMANDER', 7);
INSERT INTO test.crew (id, code, first_name, last_name, position, company_id)
VALUES (20, 'COD002', 'Miguel Ángel', 'Huerta', 'COMMANDER', 8);
INSERT INTO test.crew (id, code, first_name, last_name, position, company_id)
VALUES (22, 'COD003', 'Marta', 'Sánchez', 'FLIGHT_ATTENDANT', 9);

INSERT INTO test.flight (id, code, departure_date, duration, company_id, destination_id, origin_id,
                         plane_id)
VALUES (15, 'BA24001', '2020-11-09 17:12:25', 12.45, 7, 1, 3, 4);
INSERT INTO test.flight (id, code, departure_date, duration, company_id, destination_id, origin_id,
                         plane_id)
VALUES (19, 'BA24002', '2021-01-10 09:12:25', 3.15, 8, 2, 3, 5);
INSERT INTO test.flight (id, code, departure_date, duration, company_id, destination_id, origin_id,
                         plane_id)
VALUES (21, 'BA24003', '2020-11-10 19:15:55', 1.15, 9, 1, 2, 6);
INSERT INTO test.flight (id, code, departure_date, duration, company_id, destination_id, origin_id,
                         plane_id)
VALUES (23, 'BA24004', '2020-11-09 23:12:01', 5.97, 7, 1, 3, 4);
INSERT INTO test.flight (id, code, departure_date, duration, company_id, destination_id, origin_id,
                         plane_id)
VALUES (24, 'BA24005', '2020-11-10 22:00:00', 5.97, 7, 1, 3, 4);

INSERT INTO test.inspection (id, description, duration, final_date, initial_date, revision_type,
                             airport_id, mechanic_id, plane_id)
VALUES (25, 'Cambio de las ruedas delanteras', 150.2, '2021-01-10 09:00:00', '2021-01-01 07:00:00',
        'PERIODIC', 1, 10, 4);
INSERT INTO test.inspection (id, description, duration, final_date, initial_date, revision_type,
                             airport_id, mechanic_id, plane_id)
VALUES (26, 'Reparación de las tuercas de las puertas', 20.15, '2021-03-10 09:00:00',
        '2021-01-01 07:00:00', 'REPARATION', 2, 11, 5);
INSERT INTO test.inspection (id, description, duration, final_date, initial_date, revision_type,
                             airport_id, mechanic_id, plane_id)
VALUES (27, 'Cambio de las tuercas de las puertas', 5.37, '2021-01-10 16:00:00',
        '2021-01-01 07:00:00', 'PERIODIC', 3, 12, 6);
INSERT INTO test.inspection (id, description, duration, final_date, initial_date, revision_type,
                             airport_id, mechanic_id, plane_id)
VALUES (28, 'Cambio de las ruedas traseras', 134.23, '2021-01-10 09:00:00', '2020-11-01 07:00:00',
        'PERIODIC', 1, 10, 4);
INSERT INTO test.inspection (id, description, duration, final_date, initial_date, revision_type,
                             airport_id, mechanic_id, plane_id)
VALUES (29, 'Cambio de las persianas de las ventanillas', 5.5, '2020-10-10 13:00:00',
        '2020-10-01 06:00:00', 'PERIODIC', 2, 11, 4);

INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (16, 15);
INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (17, 15);
INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (18, 15);
INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (20, 19);
INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (16, 21);
INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (22, 21);
INSERT INTO test.crew_flight (crew_id, flight_id)
VALUES (20, 24);

INSERT INTO test.hibernate_sequence (next_val)
VALUES (30);