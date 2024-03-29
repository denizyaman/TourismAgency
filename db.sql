toc.dat                                                                                             0000600 0004000 0002000 00000023366 14557757436 0014500 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP   2                    |            TourismAgency    16.1    16.0 "    /           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         0           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         1           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         2           1262    16791    TourismAgency    DATABASE     q   CREATE DATABASE "TourismAgency" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE "TourismAgency";
                postgres    false         �            1259    16801    hotel    TABLE     �  CREATE TABLE public.hotel (
    id bigint NOT NULL,
    name text NOT NULL,
    address text NOT NULL,
    mail text NOT NULL,
    phone text NOT NULL,
    star text NOT NULL,
    carpark boolean NOT NULL,
    wifi boolean NOT NULL,
    pool boolean NOT NULL,
    fitness boolean NOT NULL,
    concierge boolean NOT NULL,
    spa boolean NOT NULL,
    room_service boolean NOT NULL
);
    DROP TABLE public.hotel;
       public         heap    postgres    false         �            1259    16800    hotel_id_seq    SEQUENCE     �   ALTER TABLE public.hotel ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218         �            1259    16809    pension    TABLE     v   CREATE TABLE public.pension (
    id bigint NOT NULL,
    hotel_id bigint NOT NULL,
    pension_type text NOT NULL
);
    DROP TABLE public.pension;
       public         heap    postgres    false         �            1259    16808    pension_id_seq    SEQUENCE     �   ALTER TABLE public.pension ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pension_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220         �            1259    16831    reservation    TABLE     �  CREATE TABLE public.reservation (
    id bigint NOT NULL,
    room_id bigint NOT NULL,
    total_price double precision NOT NULL,
    guest_count integer NOT NULL,
    guest_name character varying NOT NULL,
    guest_citizen_id character varying NOT NULL,
    guest_mail character varying NOT NULL,
    guest_phone character varying NOT NULL,
    check_in_date text NOT NULL,
    check_out_date text NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false         �            1259    16830    reservation_id_seq    SEQUENCE     �   ALTER TABLE public.reservation ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226         �            1259    16823    rooms    TABLE     �  CREATE TABLE public.rooms (
    id bigint NOT NULL,
    hotel_id bigint NOT NULL,
    room_type text NOT NULL,
    stock bigint NOT NULL,
    adult_price double precision NOT NULL,
    child_price double precision NOT NULL,
    bed_capacity bigint NOT NULL,
    m2 bigint NOT NULL,
    tv boolean NOT NULL,
    minibar boolean NOT NULL,
    console boolean NOT NULL,
    safe boolean NOT NULL,
    projection boolean NOT NULL,
    pension_id bigint,
    season_id bigint
);
    DROP TABLE public.rooms;
       public         heap    postgres    false         �            1259    16822    rooms_id_seq    SEQUENCE     �   ALTER TABLE public.rooms ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.rooms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224         �            1259    16817    seasons    TABLE     ~   CREATE TABLE public.seasons (
    id bigint NOT NULL,
    hotel_id bigint NOT NULL,
    start_date text,
    end_date text
);
    DROP TABLE public.seasons;
       public         heap    postgres    false         �            1259    16816    seasons_id_seq    SEQUENCE     �   ALTER TABLE public.seasons ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.seasons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222         �            1259    16793    user    TABLE     �   CREATE TABLE public."user" (
    user_id bigint NOT NULL,
    user_name text NOT NULL,
    user_pass text NOT NULL,
    user_role text NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false         �            1259    16792    user_user_id_seq    SEQUENCE     �   ALTER TABLE public."user" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216         $          0    16801    hotel 
   TABLE DATA           �   COPY public.hotel (id, name, address, mail, phone, star, carpark, wifi, pool, fitness, concierge, spa, room_service) FROM stdin;
    public          postgres    false    218       3620.dat &          0    16809    pension 
   TABLE DATA           =   COPY public.pension (id, hotel_id, pension_type) FROM stdin;
    public          postgres    false    220       3622.dat ,          0    16831    reservation 
   TABLE DATA           �   COPY public.reservation (id, room_id, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone, check_in_date, check_out_date) FROM stdin;
    public          postgres    false    226       3628.dat *          0    16823    rooms 
   TABLE DATA           �   COPY public.rooms (id, hotel_id, room_type, stock, adult_price, child_price, bed_capacity, m2, tv, minibar, console, safe, projection, pension_id, season_id) FROM stdin;
    public          postgres    false    224       3626.dat (          0    16817    seasons 
   TABLE DATA           E   COPY public.seasons (id, hotel_id, start_date, end_date) FROM stdin;
    public          postgres    false    222       3624.dat "          0    16793    user 
   TABLE DATA           J   COPY public."user" (user_id, user_name, user_pass, user_role) FROM stdin;
    public          postgres    false    216       3618.dat 3           0    0    hotel_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.hotel_id_seq', 9, true);
          public          postgres    false    217         4           0    0    pension_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.pension_id_seq', 23, true);
          public          postgres    false    219         5           0    0    reservation_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.reservation_id_seq', 14, true);
          public          postgres    false    225         6           0    0    rooms_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.rooms_id_seq', 16, true);
          public          postgres    false    223         7           0    0    seasons_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.seasons_id_seq', 16, true);
          public          postgres    false    221         8           0    0    user_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_user_id_seq', 12, true);
          public          postgres    false    215         �           2606    16807    hotel hotel_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    218         �           2606    16815    pension pension_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.pension
    ADD CONSTRAINT pension_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.pension DROP CONSTRAINT pension_pkey;
       public            postgres    false    220         �           2606    16837    reservation reservation_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    226         �           2606    16829    rooms rooms_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.rooms DROP CONSTRAINT rooms_pkey;
       public            postgres    false    224         �           2606    16821    seasons seasons_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.seasons
    ADD CONSTRAINT seasons_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.seasons DROP CONSTRAINT seasons_pkey;
       public            postgres    false    222         �           2606    16799    user user_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    216                                                                                                                                                                                                                                                                                  3620.dat                                                                                            0000600 0004000 0002000 00000001154 14557757436 0014274 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Hilton Hotel	Sivas/Merkez	hilton@hilton.com	5555555555	****	t	t	t	f	f	f	t
3	Fırtına Hotel	İstanbul/Beşiktaş	firtina@firtina.com	5555555555	**	t	t	t	t	t	t	t
4	Aksam Hotel	Adana	aksam@aksam.com	5555555555	*	f	f	f	f	f	f	f
2	Sabah Hotel	İzmir/Buca	sabah@sabah.com	5555555555	***	t	t	t	t	t	t	t
5	patika	istanbul	patika@patika.com	021009876	*****	t	t	t	t	t	t	t
6	deneme	izmir	deneme@deneme.com	0987654	***	f	t	t	t	t	f	f
7	deneme1	izmir	deneme@deneme.com	0984765	***	t	f	t	f	f	f	t
8	Sivas Otel	sivas/merkez	sivas@sivas.com	1234123	***	t	t	t	t	t	t	t
9	PatikaDev	Merkez/İstanbul	dev@dev.com	1234	****	t	t	t	t	t	t	t
\.


                                                                                                                                                                                                                                                                                                                                                                                                                    3622.dat                                                                                            0000600 0004000 0002000 00000000510 14557757436 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        10	4	Oda Kahvaltı
11	3	Alkol Hariç Full credit
12	4	Yarım Pansiyon
13	3	Tam Pansiyon
14	4	Yarım Pansiyon
15	1	Sadece Yatak
16	2	Ultra Her şey Dahil
17	5	Alkol Hariç Full credit
18	4	Oda Kahvaltı
19	4	Alkol Hariç Full credit
20	2	Yarım Pansiyon
21	7	Tam Pansiyon
22	8	Ultra Her şey Dahil
23	9	Ultra Her şey Dahil
\.


                                                                                                                                                                                        3628.dat                                                                                            0000600 0004000 0002000 00000000550 14557757436 0014303 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	10	640500	4	deniz2	1231231232	deniz2@deniz.com	1231231231232	2024-04-10	2024-10-10
7	10	18000	2	deneme	123456	deneme@deneme.com	2345678	2024-03-03	2024-03-12
9	10	495250	2	asd	123	asd	123	2024-01-01	2024-10-10
10	4	142500	1	deneme	12345	deneme@deneme.com	123456	2024-07-07	2024-10-10
13	15	28000	2	deniz	1234	deniz@deniz.com	12344	2024-01-01	2024-01-15
\.


                                                                                                                                                        3626.dat                                                                                            0000600 0004000 0002000 00000001077 14557757436 0014306 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        3	1	Junior suite oda	2	1000	500	3	20	f	f	f	f	f	15	7
9	4	Çift kişilik oda	2	2000	1000	4	40	t	f	t	t	f	10	9
11	4	Tek kişilik oda	3	5000	2500	7	100	t	t	f	f	f	12	8
12	4	Tek kişilik oda	4	2500	1250	5	70	t	t	t	t	t	14	9
13	2	Suite oda	4	1000	500	8	100	t	t	t	t	t	16	4
2	1	Tek Kişilik	3	1000	100	2	20	t	t	t	f	f	15	7
10	4	Tek kişilik oda	0	1000	750	6	60	f	t	t	t	f	14	3
4	4	Suite oda	1	1500	750	1	20	t	t	t	t	t	10	2
14	5	Junior suite oda	5	4000	2000	4	35	t	t	t	t	t	17	10
15	8	Tek kişilik oda	0	1000	100	2	20	t	t	t	t	t	22	15
16	9	Tek kişilik oda	1	100	10	3	20	t	t	t	t	t	23	16
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                 3624.dat                                                                                            0000600 0004000 0002000 00000000570 14557757436 0014301 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	4	2024-03-02	2024-10-20
3	4	2024-01-01	2024-12-31
4	2	2024-12-24	2024-12-31
5	3	2024-03-12	2024-07-07
7	1	2024-12-24	2024-12-30
8	4	2024-01-01	2024-04-01
9	4	2024-04-01	2024-07-01
10	5	2024-07-07	2024-12-12
11	4	2024-09-09	2024-12-12
12	5	2024-08-01	2024-09-01
13	3	2025-01-01	2025-06-01
14	7	2025-02-02	2025-03-01
15	8	2024-01-01	2024-01-15
16	9	2024-01-01	2024-01-14
\.


                                                                                                                                        3618.dat                                                                                            0000600 0004000 0002000 00000000256 14557757436 0014305 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	deneme1	1234	user
4	batuhan0	12340	user
1	admin	1234	admin
9	deneme2	deneme	user
11	denem213123	1234	user
10	deneme12143524657658769	deneme	user
12	deneme23	1234	user
\.


                                                                                                                                                                                                                                                                                                                                                  restore.sql                                                                                         0000600 0004000 0002000 00000022104 14557757436 0015412 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "TourismAgency";
--
-- Name: TourismAgency; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "TourismAgency" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';


ALTER DATABASE "TourismAgency" OWNER TO postgres;

\connect "TourismAgency"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel (
    id bigint NOT NULL,
    name text NOT NULL,
    address text NOT NULL,
    mail text NOT NULL,
    phone text NOT NULL,
    star text NOT NULL,
    carpark boolean NOT NULL,
    wifi boolean NOT NULL,
    pool boolean NOT NULL,
    fitness boolean NOT NULL,
    concierge boolean NOT NULL,
    spa boolean NOT NULL,
    room_service boolean NOT NULL
);


ALTER TABLE public.hotel OWNER TO postgres;

--
-- Name: hotel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.hotel ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: pension; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pension (
    id bigint NOT NULL,
    hotel_id bigint NOT NULL,
    pension_type text NOT NULL
);


ALTER TABLE public.pension OWNER TO postgres;

--
-- Name: pension_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pension ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pension_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id bigint NOT NULL,
    room_id bigint NOT NULL,
    total_price double precision NOT NULL,
    guest_count integer NOT NULL,
    guest_name character varying NOT NULL,
    guest_citizen_id character varying NOT NULL,
    guest_mail character varying NOT NULL,
    guest_phone character varying NOT NULL,
    check_in_date text NOT NULL,
    check_out_date text NOT NULL
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.reservation ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: rooms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rooms (
    id bigint NOT NULL,
    hotel_id bigint NOT NULL,
    room_type text NOT NULL,
    stock bigint NOT NULL,
    adult_price double precision NOT NULL,
    child_price double precision NOT NULL,
    bed_capacity bigint NOT NULL,
    m2 bigint NOT NULL,
    tv boolean NOT NULL,
    minibar boolean NOT NULL,
    console boolean NOT NULL,
    safe boolean NOT NULL,
    projection boolean NOT NULL,
    pension_id bigint,
    season_id bigint
);


ALTER TABLE public.rooms OWNER TO postgres;

--
-- Name: rooms_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.rooms ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.rooms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: seasons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seasons (
    id bigint NOT NULL,
    hotel_id bigint NOT NULL,
    start_date text,
    end_date text
);


ALTER TABLE public.seasons OWNER TO postgres;

--
-- Name: seasons_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.seasons ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.seasons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    user_id bigint NOT NULL,
    user_name text NOT NULL,
    user_pass text NOT NULL,
    user_role text NOT NULL
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."user" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel (id, name, address, mail, phone, star, carpark, wifi, pool, fitness, concierge, spa, room_service) FROM stdin;
\.
COPY public.hotel (id, name, address, mail, phone, star, carpark, wifi, pool, fitness, concierge, spa, room_service) FROM '$$PATH$$/3620.dat';

--
-- Data for Name: pension; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pension (id, hotel_id, pension_type) FROM stdin;
\.
COPY public.pension (id, hotel_id, pension_type) FROM '$$PATH$$/3622.dat';

--
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id, room_id, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone, check_in_date, check_out_date) FROM stdin;
\.
COPY public.reservation (id, room_id, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone, check_in_date, check_out_date) FROM '$$PATH$$/3628.dat';

--
-- Data for Name: rooms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rooms (id, hotel_id, room_type, stock, adult_price, child_price, bed_capacity, m2, tv, minibar, console, safe, projection, pension_id, season_id) FROM stdin;
\.
COPY public.rooms (id, hotel_id, room_type, stock, adult_price, child_price, bed_capacity, m2, tv, minibar, console, safe, projection, pension_id, season_id) FROM '$$PATH$$/3626.dat';

--
-- Data for Name: seasons; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seasons (id, hotel_id, start_date, end_date) FROM stdin;
\.
COPY public.seasons (id, hotel_id, start_date, end_date) FROM '$$PATH$$/3624.dat';

--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (user_id, user_name, user_pass, user_role) FROM stdin;
\.
COPY public."user" (user_id, user_name, user_pass, user_role) FROM '$$PATH$$/3618.dat';

--
-- Name: hotel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotel_id_seq', 9, true);


--
-- Name: pension_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pension_id_seq', 23, true);


--
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 14, true);


--
-- Name: rooms_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rooms_id_seq', 16, true);


--
-- Name: seasons_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seasons_id_seq', 16, true);


--
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_user_id_seq', 12, true);


--
-- Name: hotel hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (id);


--
-- Name: pension pension_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pension
    ADD CONSTRAINT pension_pkey PRIMARY KEY (id);


--
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);


--
-- Name: rooms rooms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_pkey PRIMARY KEY (id);


--
-- Name: seasons seasons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seasons
    ADD CONSTRAINT seasons_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            