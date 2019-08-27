<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">资源仓库管理</h3>
				<div class="box-tools pull-right">
					<@shiro.hasPermission name="dir/add">
						<a onclick="dirToListAjax();" class="btn btn-sm btn-primary" target="modal" modal="lg" href="/dir/add">添加</a>
					</@shiro.hasPermission>
				</div>
			</div>
			<div class="box-body">
				<table id="dir_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<tr>
								<th>序号</th>
								<th>根目录</th>								
								<th>状态</th>
								<th>编辑员</th>
								<th>操作</th>
							</tr>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
var dir_tab;
$(function() {
//alert("function")
	//初始化表格
	var No=0;
	dir_tab = $('#dir_tab').DataTable({
		"dom":'itflp',
		"processing":true,
		"searching":false,
		"serverSide":true, //启用服务器端分页
		"bInfo":false,
		"language":{"url":"adminlte/plugins/datatables/language.json"},
		"ajax":{"url":"/dir/page","type":"post"},
		"columns":[ 
		    {"data":null}, 
			{"data":"url"},
			{"data":null},
			{"data":"editUser"},
			{"data":null} 
			],
		"columnDefs" : [
			{
			    targets: 0,
			    data: null,
			    render: function (data) {
			    	No=No+1;
			        return No;
			    }
			},
			{
			    targets: 2,
			    data: null,
			    render: function (data) {
			    
			    	if(data.status == 0){
			    		return "不可用";
			    	}
			    	if(data.status == 1){
			    		return "可用";
			    	}
			    	return "未知状态";
			    }
			},
            {
				"targets" : -1,
				"data" : null,
				"render" : function(data) {
									
					var btn = '<@shiro.hasPermission name="dir/edit">'
					+'<a class="btn btn-xs btn-info" onclick="dirToListAjax();" target="modal" modal="lg" href="/dir/edit/'+ data.id+'">修改</a> &nbsp;'
					+'</@shiro.hasPermission>'
					+'<@shiro.hasPermission name="dir/delete">'
					+'<a class="btn btn-xs btn-default" callback="dirReload();" data-body="确认要删除吗？" target="ajaxTodo" href="/dir/delete/'+ data.id + '">删除</a>  &nbsp;'
					+'</@shiro.hasPermission>'
						
				return btn;
			}
		} ]
	}).on('preXhr.dt', function ( e, settings, data ) {
	console.log(data,settings)
		No=0;
    } );
});

function dirReload(){
	reloadTable(dir_tab,"#dirTime","#dirPremise");
}

function dirToListAjax(){
	list_ajax = dir_tab;
}
</script>