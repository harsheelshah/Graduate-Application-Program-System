
    create table gapp_academic_records (
        arid int4 not null,
        GPA varchar(255),
        collegename varchar(255),
        degreeearned varchar(255),
        major varchar(255),
        timeattended varchar(255),
        appid_appid int4,
        primary key (arid)
    );

    create table gapp_additional (
        additionalid int4 not null,
        additionalname varchar(255),
        field varchar(255),
        required boolean not null,
        stringvalue varchar(255),
        type varchar(255),
        appid_appid int4,
        deptid_deptid int4,
        fileadditionalid_fileadditionalid int4,
        primary key (additionalid)
    );

    create table gapp_additional_file (
        fileadditionalid int4 not null,
        fileadditionalname varchar(255),
        primary key (fileadditionalid)
    );

    create table gapp_application_status (
        statusid int4 not null,
        comments varchar(255),
        name varchar(255),
        primary key (statusid)
    );

    create table gapp_applications (
        appid int4 not null,
        CIN varchar(255),
        DOB varchar(255),
        Date timestamp,
        GRE varchar(255),
        TOEFL varchar(255),
        applicantemail varchar(255),
        applicantfirstname varchar(255),
        applicantlastname varchar(255),
        citizenship varchar(255),
        gender varchar(255),
        phone varchar(255),
        term varchar(255),
        id_id int4,
        prgmid_prgmid int4,
        statusid_statusid int4,
        transcript_fileid int4,
        primary key (appid)
    );

    create table gapp_department (
        deptid int4 not null,
        departmentname varchar(255),
        primary key (deptid)
    );

    create table gapp_file (
        fileid int4 not null,
        filename varchar(255),
        size int8,
        type varchar(255),
        primary key (fileid)
    );

    create table gapp_list_status (
        list_status_id int4 not null,
        description varchar(255),
        primary key (list_status_id)
    );

    create table gapp_program (
        prgmid int4 not null,
        programname varchar(255),
        deptid_deptid int4,
        primary key (prgmid)
    );

    create table gapp_status (
        statid int4 not null,
        desription varchar(255),
        name varchar(255),
        primary key (statid)
    );

    create table gapp_user_additional (
        addid int4 not null,
        name varchar(255),
        value varchar(255),
        primary key (addid)
    );

    create table gapp_users (
        id int4 not null,
        CIN varchar(255),
        DOB timestamp,
        citizenship varchar(255),
        email varchar(255),
        firstname varchar(255),
        gender varchar(255),
        lastname varchar(255),
        password varchar(255),
        phone varchar(255),
        primary key (id)
    );

    create table gapp_users_gapp_user_additional (
        gapp_users_id int4 not null,
        addid_addid int4 not null
    );

    create table gapp_users_gapp_users_type (
        gapp_users_id int4 not null,
        typeid_typeid int4 not null
    );

    create table gapp_users_type (
        typeid int4 not null,
        type varchar(255),
        primary key (typeid)
    );

    alter table gapp_users_gapp_user_additional 
        add constraint UK_po1ssxqglp7m0ebjbescpiceq unique (addid_addid);

    alter table gapp_academic_records 
        add constraint FK_l8is31c5et5ogw76m5xa0tmm9 
        foreign key (appid_appid) 
        references gapp_applications;

    alter table gapp_additional 
        add constraint FK_hr1859784fgfi6ajlc5jndgk8 
        foreign key (appid_appid) 
        references gapp_applications;

    alter table gapp_additional 
        add constraint FK_dc9b99i5yf95w6qet5cobqju5 
        foreign key (deptid_deptid) 
        references gapp_department;

    alter table gapp_additional 
        add constraint FK_pex02y0esd2ov2nel76s7uygi 
        foreign key (fileadditionalid_fileadditionalid) 
        references gapp_additional_file;

    alter table gapp_applications 
        add constraint FK_9bba0dnm2qgsl0lchewb9tdow 
        foreign key (id_id) 
        references gapp_users;

    alter table gapp_applications 
        add constraint FK_snbay1hao8l6ctw7v9n41u45q 
        foreign key (prgmid_prgmid) 
        references gapp_program;

    alter table gapp_applications 
        add constraint FK_8q7a763c9le1pw4rlwdq79pdg 
        foreign key (statusid_statusid) 
        references gapp_application_status;

    alter table gapp_applications 
        add constraint FK_qc0fe80ylahfe63nr5h0s83uu 
        foreign key (transcript_fileid) 
        references gapp_file;

    alter table gapp_program 
        add constraint FK_ehqw69faxyflijsucso47n91x 
        foreign key (deptid_deptid) 
        references gapp_department;

    alter table gapp_users_gapp_user_additional 
        add constraint FK_po1ssxqglp7m0ebjbescpiceq 
        foreign key (addid_addid) 
        references gapp_user_additional;

    alter table gapp_users_gapp_user_additional 
        add constraint FK_6upq7c38in6tr0tms7gtr1lbg 
        foreign key (gapp_users_id) 
        references gapp_users;

    alter table gapp_users_gapp_users_type 
        add constraint FK_ua9ntqc07ug140tur5x2q95d 
        foreign key (typeid_typeid) 
        references gapp_users_type;

    alter table gapp_users_gapp_users_type 
        add constraint FK_8i7kx7jl3fumo2xb7e6an3yjf 
        foreign key (gapp_users_id) 
        references gapp_users;

    create sequence hibernate_sequence;
