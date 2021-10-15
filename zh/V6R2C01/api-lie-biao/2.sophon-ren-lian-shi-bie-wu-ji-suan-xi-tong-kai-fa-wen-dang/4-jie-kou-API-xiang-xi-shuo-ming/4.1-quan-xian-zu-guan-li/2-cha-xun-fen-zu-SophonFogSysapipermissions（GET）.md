# 查询权限组信息/sophon/v2/face/getpermission（POST）

**版本**

2.0

**功能描述**

查询一个的权限组。

**调用URL**

调用方法: POST

**请求参数**

<table>
	<tr>
	    <th>参数</th>
	    <th>类型</th>
	    <th>默认值</th> 
        <th>选择</th>
        <th>描述</th>
        <th>举例</th>
	</tr >
   	<tr >
        <td>permission_id</td>
        <td>string</td>
        <td>无</td>
	    <td rowspan="2">必选，二选一</td>
	    <td>全局唯一的权限组标识，可以用来管理权限组对象。</td>
	    <td>”测试组“</td>
	</tr> 
   	<tr >
        <td>permission_name</td>
        <td>string</td>
        <td>无</td>
	    <td>权限组名称</td>
	    <td>”测试组_id1“</td>
	</tr> 
</table>


请求示例：

```json
请求url: 

```



**返回信息：**

请求成功

| 参数            | 类型   | 描述                                           |
| :-------------- | :----- | :--------------------------------------------- |
| permission_name | string | 权限组名词                                     |
| permission_id   | string | 全局唯一的权限组标识，可以用来管理权限组对象。 |
| description     | string | API调用者自定义信息。创建时候传递进来的数据。  |

请求成功示例：

```json
{

}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

错误码：

| Index | 错误码 | 描述 |
| ----- | ------ | ---- |
|       |        |      |
|       |        |      |
|       |        |      |

