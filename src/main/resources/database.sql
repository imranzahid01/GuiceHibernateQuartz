CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `dept` (`deptno`, `dname`, `loc`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

CREATE TABLE `emp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` varchar(12) DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `emp` (`empno`, `ename`, `job`, `boss`, `hiredate`, `sal`, `comm`, `deptno`) VALUES
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', '800.00', NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', '1600.00', '300.00', 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', '1250.00', '500.00', 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', '2975.00', NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', '1250.00', '1400.00', 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', '2850.00', NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', '2450.00', NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', '3000.00', NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', '5000.00', NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', '1500.00', '0.00', 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', '1100.00', NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', '950.00', NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', '3000.00', NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', '1300.00', NULL, 10);