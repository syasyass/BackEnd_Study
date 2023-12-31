CREATE TABLE DEPT_TEMP
AS SELECT * FROM DEPT;

SELECT * FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)
VALUES(50, 'DATAVASE', 'SEOUL');

SELECT * FROM DEPT_TEMP;

--INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)

-- 열 지정 없이 데이터 추가
INSERT INTO DEPT_TEMP
VALUES(60, 'NETWORK', 'BUSAN');

SELECT * FROM DEPT_TEMP;

-- NULL 데이터 추가
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES(70, 'WEB', NULL)

INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES(80, 'MOBILE', '');

INSERT INTO DEPT_TEMP(DEPTNO, LOC)
VALUES(80, 'INCHEON');

SELECT * FROM DEPT_TEMP;

CREATE TABLE EMP_TEMP
AS SELECT * FROM EMP
WHERE 1 <> 1; -- FALSE. 골격만 복사하라는 것

SELECT * FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(9999, '홍길동', 'PRESIDENT', NULL, TO_DATE('01/01/2001', 'DD/MM/YYYY'), 5000, 1000, 10); --날짜 표기법 참고

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(1111, '성춘향', 'MANGER', 9999, TO_DATE('05/01/2001', 'DD/MM/YYYY'), 4000, NULL, 20); 

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(2111, '이순신', 'MANGER', 9999, TO_DATE('07/01/2001', 'DD/MM/YYYY'), 4000, NULL, 20); 

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(3111, '심청이', 'MANGER', 9999, SYSDATE, 4000, NULL, 30); --가장 많이 쓰는 방법. SYSDATE.

SELECT * FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
AND S.GRADE = 1;

SELECT * FROM EMP_TEMP;

SELECT *
FROM NLS_SESSION_PARAMETERS; --로케일 정보 확인

CREATE TABLE DEPT_TEMP2
AS SELECT * FROM DEPT;

UPDATE DEPT_TEMP2
SET LOC = 'SEOUL';

DROP TABLE DEPT_TEMP2;

SELECT * FROM DEPT_TEMP2;

ROLLBACK; --UPDATE 되돌리기

UPDATE DEPT_TEMP2
SET DNAME = 'DATABASE',
LOC = 'SEOUL'
WHERE DEPTNO = 40;

UPDATE DEPT_TEMP2
SET (DNAME, LOC) = (SELECT DNAME, LOC
FROM DEPT
WHERE DEPTNO = 40)
WHERE DEPTNO = 40;

UPDATE DEPT_TEMP2
SET LOC = 'SEOUL'
WHERE DEPTNO = (SELECT DEPTNO
FROM DEPT_TEMP2
WHERE DNAME = 'OPERATIONS');

SELECT * FROM DEPT_TEMP2;

--------------------------------------------
CREATE TABLE EMP_TEMP2
AS SELECT * FROM EMP;

SELECT * FROM EMP_TEMP2;

DELETE FROM EMP_TEMP2
WHERE JOB = 'MANAGER';

--오라클 SQL JOIN
DELETE FROM EMP_TEMP2
WHERE EMPNO IN (SELECT E.EMPNO
				FROM EMP_TEMP2 E, SALGRADE S
				WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
				AND S.GRADE = 3
				AND DEPTNO = 30);

--표준 SQL JOIN
SELECT E.EMPNO
FROM EMP_TEMP2 E JOIN SALGRADE S
	ON(E.SAL BETWEEN S.LOSAL AND S.HISAL)
WHERE S.GRADE = 3 AND DEPTNO = 30;

DELETE FROM EMP_TEMP2;

SELECT * FROM EMP_TEMP2;


-- ROWID, ROWNUM --> 의사(PSEUDO) 컬럼
SELECT ROWID, ROWNUM, E.* FROM EMP E
ORDER BY E.HIREDATE;





