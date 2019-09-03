<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">列表</h3>
				<div class="box-tools pull-right">
					
						<a onclick="fileToListAjax();" class="btn btn-sm btn-primary" target="modal" modal="lg" href="/file/allDownload">下载</a>
					
				</div>
			</div>
			<div class="box-body">
				<table id="file_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<tr>
								<th>序号</th>
								<th>用户</th>								
								<th>送货地址</th>
								<th>品名</th>
								<th>送货日期</th>
								<th>编号</th>
								<th>文件名</th>								
								<th>上传时间</th>
								<th>上传员</th>
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
var file_tab;
$(function() {
//alert("function")
	//初始化表格
	var No=0;
	file_tab = $('#file_tab').DataTable({
		"dom":'itflp',
		"processing":true,
		"searching":false,
		"serverSide":true, //启用服务器端分页
		"bInfo":false,
		"language":{"url":"adminlte/plugins/datatables/language.json"},
		"ajax":{"url":"/file/page","type":"post"},
		"columns":[ 
		    {"data":null}, 
			{"data":"cust_name"},
			{"data":"shipping_addr"},
			{"data":"cust_part"},
			{"data":"shipping_dt"},
			{"data":"shipping_jccjs_no"}, 
			{"data":"upload_filename"},
			{"data":"upload_dt"},
			{"data":"upload_user"},
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
				"targets" : -1,
				"data" : null,
				"render" : function(data) {
									
					var btn = '<a class="btn btn-xs btn-info"   href="/file/preview/'+ data.id+'/'+ data.status+'">预览</a> &nbsp;'
					+'<a class="btn btn-xs btn-info"  href="/file/download/'+ data.id+'/'+ data.status+'">下载</a> &nbsp;'
										
					+'<a class="btn btn-xs btn-default" callback="fileReload();" data-body="确认要删除吗？" target="ajaxTodo" href="/file/delete/'+ data.id + '">删除</a>  &nbsp;'
					
						
				return btn;
			}
		} ]
	}).on('preXhr.dt', function ( e, settings, data ) {
	console.log(data,settings)
		No=0;
    } );
});

function fileReload(){
	reloadTable(file_tab,"#fileTime","#filePremise");
}

function fileToListAjax(){
	list_ajax = file_tab;
}
</script>