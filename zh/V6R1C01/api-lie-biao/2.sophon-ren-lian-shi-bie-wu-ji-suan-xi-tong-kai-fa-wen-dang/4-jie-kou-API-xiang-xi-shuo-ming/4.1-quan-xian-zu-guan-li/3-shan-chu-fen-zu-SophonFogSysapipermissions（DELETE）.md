# 删除权限组/sophon/v2/face/deletepermission (POST)

**功能描述**

删除指定id的权限组

**调用URL**



**调用方法**

POST

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
        <td>permission_name</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一</br>若两个都指定，则permission_name有效</td>
	    <td>权限组名称</td>
	    <td>”测试组“</td>
	</tr> 
   	<tr >
        <td>permission_id</td>
        <td>string</td>
        <td>无</td>
	    <td>全局唯一的权限组标识，可以用来管理权限组对象。</td>
	    <td>”测试组_id1“</td>
	</tr> 
</table>


请求示例：

```json
请求url: 
请求body:
	{
        "permission_name":"测试组"
	}
```

**返回信息：**

请求成功

| 一级参数      | 描述                               |
| :------------ | :--------------------------------- |
| permission_id | 如果删除成功，返回已删除的权限组id |

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

