<a href="https://996.icu"><img src="https://img.shields.io/badge/link-996.icu-red.svg" alt="996.icu" /></a>

# light_plugin_core  V0.0.1

#### 项目结构：

lib_light_plugin_core: 插件化核心功能library

module_host_main：宿主工程主工程，负责加载部署apk

module_client_one:测试业务apk 1

module_client_two:测试业务apk 2



#### 功能与特性：

1、支持Android 2.3 以上版本

2、支持R文件资源直接调用

3、开发过程中无发射调用

4、apk无需安装直接调用

5、代理模式对代码侵入性少

6、使用简单，只需要继承简单的类即可




使用说明：
1.AndroidManifest.xml
  <!--必须设置root_class-->
        <meta-data
            android:name="root_class"
            android:value="com.jack.clientdome.TestClass" />

        <meta-data
            android:name="two_class"
            android:value="com.jack.clientdome.TwoClass" />
2.跳转
         JackUtils.goActivity(activity,"first_apk", "two_class");
