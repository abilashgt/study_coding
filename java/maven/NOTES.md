Why?
----
Build Tool
Project Management

Common Problems
---------------
Multiple Jars
Dependencies (versions)
Project Structure
Build - Publish - Deploy

Dependency
----------
- we need to include only the main dependencies. 
- maven downloads and includes the rest of the dependencies dependend on the main depencies.

Create
------
# mvn archetype:generate
- default 106
- groupid - similar to package name
- artificatId - similar to class name. jar to going to create
- version - choose default
- package - default to groupid

Build info
----------
jar, war etc.

Build
-----
# mvn compile
# mvn package
- creating jar
- run the test case

Execute
-------
java -cp target/xxx.jar package.package.App


Maven Repository Content
------------------------
1) Archtype info
2) Dependency info

Identity
--------
- group id
- artifact id
- version


Build Process
-------------
- lifecycle
1. Validate
2. Compile - java to class files
3. Test
4. Package - output jar
5. Install - put jar into local maven
6. Deploy - publishing your artifact. share


Note:
Cleans the repo
# mvn clean


Scope
-?

Plugins
-?