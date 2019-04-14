# 共享汽车后台管理系统API文档

## 目录

1. [序言](#序言) 
2. [全局code](#全局code)
3. [全局sign算法](#全局sign算法)
4. [用户相关](#用户相关)  
4.1 [登录](#登录)
5. [数据字典](#数据字典)  
5.1 [User](#User)

## 序言

- 程序采用前后端分离，本文档提供网络请求API。

## 全局code

返回code|解释
-|-|
1000|成功
1001|sign验证失败
1002|token验证失败

## 全局sign算法
- 所有的请求在服务器端统一验证sign
- sign由所有POST上传的参数和signstring决定
- 服务器端校验当前上传的timestamp和服务器端的timestamp，若当前timestamp太老，则判断请求失效
- sign算法为所有的参数字典序排序，然后key和value连接起来，最后加signstring，对这个字符串取md5值  
如：上传参数为`username=asadsad&timestamp=1555226180000&sign=f556929c24857816bb52ea5ded41dfb5`  
则对字符串：  
`timestamp1555226180000usernameasadsadqwfhasio4568/asd12iids`  
取md5运算  
即：  
`sign=md5("timestamp1555226180000usernameasadsadqwfhasio4568/asd12iids")`
其中`qwfhasio4568/asd12iids` 是前后端约定的signstring
## 用户相关

### 登录
#### 简要描述：
- 用户登录接口
#### 请求url：
- /api/user/login
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
password|是|String|密码
timestamp|是|String|13位当前时间戳
sign|是|String|[sign签名](#全局sign算法)
#### 返回格式
``` json
    {
        "code":1000,
        "msg":"登录成功"
    } 
```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|错误说明
code|是|int|[参加全局code](#全局code)

## 数据字典

### User

字段|类型|空|默认|注释|主码
-|-|-|-|-|-|
id|int(10)|否||自增|是
username|varchar(25)|否||用户名|否
password|varchar(32)|否||密码|否

- 备注：无
