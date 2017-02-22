# RPC for thrift grpc hessian avro

## thrift
### 安装thrift
1.到官网下载exe文件，下载地址： http://thrift.apache.org/download

2.将exe文件重命名为thrift.ext，添加到path路径

3.在项目工程引入thrift依赖

4.编写thrift接口文件文件

5.在命令行输入如：thrift -gen java .\hello.thrift ，默认生成在当前目录，可通过-o指定生成路径

6.不使用工具生成的代码，自己编写接口实现


## grpc
1. 添加grpc依赖与protoc插件

2. 编写proto文件

3. 代码生成，通过右键工程，找到maven菜单，选择Generate Sources and Update Folders，即可在target的generated-sources目录下找到生成的java代码
   吐槽，代码生成速度忒慢了，感觉这插件太糟糕了，thrift生成快多了
   
   *刚刚突然发现使用mvn install命令，能迅速的生成相关的插件和java代码。Oh, good! I have it.*
   
## hessian
hessian折腾了我好久，坑，它的请求路径必须已hessian开头