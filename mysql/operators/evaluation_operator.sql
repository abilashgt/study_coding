/*
INTERVAL
BINARY, COLLATE
!
- (unary minus), ~ (unary bit inversion)
^
*, /, DIV, %, MOD
-, +
<<, >>
&
|
= (comparison), <=>, >=, >, <=, <, <>, !=, IS, LIKE, REGEXP, IN
BETWEEN, CASE, WHEN, THEN, ELSE
NOT
&&, AND
XOR
||, OR
= (assignment), :=
*/

#eg1
SELECT (age + 3 * 4 / 2 - 8) from authors;
SELECT (3 * 4 / 2 - 8);
SELECT (3 * 4 / 2);

#eq2
SELECT 1+2*3; # -> 7
SELECT (1+2)*3; #-> 9
