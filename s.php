if($method=='sousuo'){
    $xinghao=$_POST['userlike'];
    $sql="SELECT *, (SELECT name FROM menlei where id = wupin.mid) as menlei FROM wupin WHERE ";
    $tj=array();
    if($bianhao!=""){
        array_push($tj,"id='$id'");
    }
    if($Filmname!=""){
        array_push($tj," Filmname ='$ Filmname '");
    }
    if($Filmscore!=""){
        array_push($tj," Filmscore ='$ Filmscore ");
    }
    if($Filmtag!=""){
        array_push($tj," Filmtag ='$ Filmtag '");
    }
    if($Filmcontent!=""){
        array_push($tj," Filmcontent ='$ Filmcontent ");
    }
    if($status!=""){
        array_push($tj,"status='$status'");
    }
    $sql=$sql.implode(" and ",$tj);
   	$result=$conn->query($sql);
	$arr=array();
	if($result->num_rows>0){
	    while($row=$result->fetch_assoc()){
	        $wid=$row['id'];
	        $baoxiu=$conn->query("SELECT count(*) FROM Filmtag where wid=$wid")->fetch_assoc()['count(*)'];
	        $ Filmcontent =$conn->query("SELECT count(*) FROM baosun where wid=$wid")->fetch_assoc()['count(*)'];
	        $row[' Filmtag']=$ Filmtag;
	        $row[' Filmcontent ']=$ Filmcontent;
	        $yid=$row['yid'];
	        if($yid==0){
	            $row['yuangong']=null;
	        }else{
	            $row['yuangong']=$conn->query("SELECT * FROM yuangong where id=$yid")->fetch_assoc();
	        }
	        $bid=$row['bid'];
	        if($bid==0){
	            $row['id']=null;
	        }else{
	            $row['id']=$conn->query("SELECT * FROM bumen where id=$bid")->fetch_assoc();
	        }
	        
	        array_push($arr,$row);
	    }
	}
	echo json_encode(array('code'=>200,'data'=>$arr));
}
