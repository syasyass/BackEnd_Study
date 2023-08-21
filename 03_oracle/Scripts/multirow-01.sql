SELECT SUM(SAL) FROM EMP;

SELECT SUM(DISTINCT SAL),
	SUM(ALL SAL),
	SUM(SAL)
FROM EMP;

SELECT COUNT(COMM) FROM EMP;

SELECT COUNT(*) FROM EMP;

SELECT COUNT(*) FROM EMP WHERE DEPTNO = 30;

SELECT COUNT(DISTINCT SAL),
	COUNT(ALL SAL),
	COUNT(SAL)
FROM EMP;

SELECT COUNT(COMM) FROM EMP;

SELECT COUNT(*) FROM EMP
WHERE COMM IS NOT NULL;

SELECT MAX(SAL) FROM EMP
WHERE DEPTNO = 10;

SELECT MIN(SAL) FROM EMP
WHERE DEPTNO = 10;

SELECT MAX(HIREDATE) FROM EMP
WHERE DEPTNO = 20;

SELECT MIN(HIREDATE) FROM EMP
WHERE DEPTNO = 20;

SELECT AVG(SAL) FROM EMP
WHERE DEPTNO = 30;

SELECT AVG(DISTINCT SAL) FROM EMP
WHERE DEPTNO = 30;

SELECT DEPTNO, AVG(SAL) FROM EMP
GROUP BY DEPTNO;

SELECT DEPTNO, COUNT(EMPNO)
FROM EMP
GROUP BY DEPTNO;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY JOB;

SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY JOB;

SELECT ENAME, DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, ENAME;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE SAL <= 3000
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;

