##0.配置java环境变量##
这里就不详细说明了，没有学过java的话可以去Google 或者 百度看看配置环境变量，有详细的步骤。
##1.你需要的文件：##
####压缩文件成zip格式：ZipFile.java,ant-1.6.5.jar####
####解压zip文件：UnZip.java,ant-1.6.5.jar####
####解压rar文件：UncodeRar.java,junrar-0.7.jar,commons-logging.jar####
##2.修改code中的压缩/解压缩路径##
####java文件中定义的final常量，如下：####
a.ZipFile.java中：<br/>
<pre>
private static final File WILL_BE_ZIPED_FILE_1 =new File("C:\\Users\\shenw1\\Downloads\\201605017.rar");
private static final File WILL_BE_ZIPED_FILE_2 =new File("C:\\Users\\shenw1\\Downloads\\201605018.rar");
private static String NEW_ZIP_FILE = "C:\\codes\\unRar\\new.zip";
</pre>
b.UnZip.java中：<br/>
<pre>
private static final String OLD_FILE = "C:\\codes\\unRar\\new.zip";
private static final String UNZIP_OLD_FILE_TO_PATH = "C:\\codes\\unRar\\test\\";
</pre>
c.UncodeRar.java中：<br/>
<pre>
private static final String OLD_RAR_FILE = "C:\\Users\\shenw1\\Downloads\\201605017.rar";
private static final String DIRECTORY_PATH = "C:\\codes\\unRar";
</pre>
##3.运行方法##
####eclipse运行####
<ul>
a.如果你有eclipse,可以直接copy文件到你的project中去，注意java顶部的package哦。<br/>
b.把需要的jar包放到reference Libraries中去，具体的应该都知道，build path->...<br/>
c.run as application<br/>
####在命令行运行####
a.把所有需要的文件放到一个文件夹A中，需要把java文件顶部的package去掉，不然会出错。<br/>
b.打开cmd命令窗口，切换到文件夹A下，命令cd C:/...<br/>
c.根据上面提示所需要的文件：<br/>
如果需要的jar文件只有一个：ant-1.6.5.jar,run command: <br/>
<pre>
javac -classpath ./ant-1.6.5.jar ZipFile.java<br/>
java -classpath .;./ant-1.6.5.jar ZipFile<br/>
</pre>
如果需要的jar文件有两个：junrar-0.7.jar,commons-logging.jar,run command:<br/>
<pre>
javac -classpath ./junrar-0.7.jar;commons-logging.jar UncodeRar.java<br/>
java -classpath .;./junrar-0.7.jar;commons-logging.jar UncodeRar<br/>
</pre>
[注]命令最后的java文件根据你跑的文件而定。
