##0.配置java环境变量##
这里就不详细说明了，没有学过java的话可以去Google 或者 百度看看配置环境变量，有详细的步骤。
##1.压缩文件成zip格式##
###你需要的文件：ZipFile.java,ant-1.6.5.jar### 
##2.解压zip文件##
###你需要的文件：UnZip.java,ant-1.6.5.jar###
##3.解压rar文件##
###你需要的文件：UncodeRar.java,junrar-0.7.jar,commons-logging.jar.###
###这里提供两种运行方法：###
(1)eclipse运行：<br/>
a.如果你有eclipse,可以直接copy文件到你的project中去，注意java顶部的package哦。<br/>
b.把需要的jar包放到reference Libraries中去，具体的应该都知道，build path->...<br/>
c.run as application<br/>
(2)在命令行运行：<br/>
a.把所有需要的文件放到一个文件夹A中<br/>
b.打开cmd命令窗口，切换到文件夹A下，命令cd C:/...<br/>
c.run command: javac -classpath ./junrar-0.7.jar;commons-logging.jar UncodeRar.java(这一步是编译)<br/>
d.run command: java -classpath .;./junrar-0.7.jar;commons-logging.jar UncodeRar<br/>
