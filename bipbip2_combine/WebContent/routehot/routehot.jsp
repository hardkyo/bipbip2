
<%@page import="com.kitri.map.model.MapDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script language="javascript" src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=b049998c-19f6-379f-893e-bd72e90ed980"></script>
<%
List<MapDto> list = (List<MapDto>) request.getAttribute("list");

%>
<style type="text/css">
div#je{float:left; margin:0 }

</style>
 <div class="container-fluid">

    
   <div class="row">
      <div class="col-md-12">
          <span class="label label-default">��õ���</span>
          <a href="/board/gallery.jsp"><span class="label label-default">�������Խ��ǰ���</span></a>
     <div class="row">

<%
int size=list.size();
if(size!=0){
   for(MapDto mapDto : list){

%>  
	<div id="je">
            <div class="col-md-<%=mapDto.getSeq() %>" style="display:inline-block;">

      
          <a id="modal-<%=mapDto.getSeq() %>" href="#modal-container-<%=mapDto.getSeq() %>" role="button" class="btn" data-toggle="modal">

<br>
          <%=mapDto.getLoc1() %>���� <%=mapDto.getLoc2() %>
          <br>
                <%=mapDto.getId() %>
                <%=mapDto.getLogtime()%>
                </a>
                <%@ include file="/routehot/cs.jsp" %>
               <div class="modal fade" id="modal-container-<%=mapDto.getSeq() %>" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                 
                     <div class="modal-content">
                        <div class="modal-header">
                            
                           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                              ��
                           </button>
                           <h4 class="modal-title" id="myModalLabel">
                              <%=mapDto.getLoc1() %>���� <%=mapDto.getLoc2() %>����
                           </h4>
                        </div>
                        <div class="modal-body">
                          
                           <%=mapDto.getMemo()%>
                        </div>
                        <div class="modal-footer">
                            ��ȸ��: <%=mapDto.getHit() %>
                           <button type="button" class="btn btn-default" data-dismiss="modal">
                              �ݱ�
                           </button> 
                           <button type="button" class="btn btn-primary">
                              Ȯ��
                           </button>
                        </div>
                     </div>
                     
                  </div>
                  
               </div>
                           </div>
               </div>
           
 <%
   }
} else{
%>
<script>
alert("�������� url�����Դϴ�.");              
   </script>
   <%
}
   %>
   
   <script>
    window.onload = function() {
    </script>
    	<%
    	size=list.size();
    	if(size!=0){
    	   for(MapDto mapDto : list){

    	%>
    	<script> 
  initialize<%=mapDto.getSeq()%>();
  </script>
  <%
    	   }

    	}
      	 %> 
            
<script>	
}	
    </script>     
         </div>
  
      </div>

   </div>
</div>
<!-- <script>
var map; -->
</script>

