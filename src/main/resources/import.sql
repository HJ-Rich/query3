insert into roadmap(roadmap_id, roadmap_name) values(roadmap_seq.nextval, '기초');
insert into roadmap(roadmap_id, roadmap_name) values(roadmap_seq.nextval, '중급');
insert into roadmap(roadmap_id, roadmap_name) values(roadmap_seq.nextval, '심화');

insert into lecture(lecture_id, lecture_name, roadmap_id) values(lecture_seq.nextval, 'PMS', 2);
insert into lecture(lecture_id, lecture_name, roadmap_id) values(lecture_seq.nextval, 'API', 2);
insert into lecture(lecture_id, lecture_name, roadmap_id) values(lecture_seq.nextval, 'WINGS', 2);
insert into lecture(lecture_id, lecture_name, roadmap_id) values(lecture_seq.nextval, 'GG', 2);
insert into lecture(lecture_id, lecture_name, roadmap_id) values(lecture_seq.nextval, 'RUN', 2);

insert into chapter(chapter_id, chapter_name, lecture_id) values(chapter_seq.nextval, 'PMS 세팅', 2);
insert into chapter(chapter_id, chapter_name, lecture_id) values(chapter_seq.nextval, '팝업창', 2);
insert into chapter(chapter_id, chapter_name, lecture_id) values(chapter_seq.nextval, '예약', 2);

insert into chapter(chapter_id, chapter_name, lecture_id) values(chapter_seq.nextval, '호호', 3);