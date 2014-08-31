<%@page import="Bean.IngredientBean"%>
<%@page import="Bean.PackagedBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.UsersBean"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <title>Point of Sales | Chopsticks &amp; Spoon</title>
  <meta name="description" content="">
  <meta name="author" content="">  
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
  <link rel="stylesheet" href="css/style.css">
  <link rel="icon" href="images/favicon.ico">
</head>
<body id="body_pos">
  <div class="wrap">
      <% UsersBean useraccount = new UsersBean();
            useraccount = (UsersBean)session.getAttribute("userAccount");%>
  <!--SIDENAV START-->
  <div class="wrapSideNav">
    <div class="sideNav">
	  <div class="userProfile">
	    <span class="username"><%out.println(useraccount.getUser_name());%></span>
		<span class="position"><%out.println(useraccount.getUser_level());%></span>
	  </div>
                <% ArrayList<IngredientBean> ilist = (ArrayList<IngredientBean>) session.getAttribute("ingredientlist");
                    int ingredientNotif = 0;
                    for(int i = 0; i < ilist.size(); i++){
                        if(ilist.get(i).getIngredient_needSupply() == 1)
                            ingredientNotif++;
                    }%>
                    <% ArrayList<PackagedBean> plist = (ArrayList<PackagedBean>) session.getAttribute("packagedlist");
                    int packagedNotif = 0;
                    for(int j = 0; j < plist.size(); j++){
                        if(plist.get(j).getPackaged_needSupply() == 1)
                            packagedNotif++;
                    }%>
	  <ul>
	    <li class="nav_pos"><a href="pos.jsp" title="Point of Sales">Point of Sales</a></li>
	    <li class="nav_ingredients"><a href="GetIngredientListServlet" title="Ingredients">Ingredients <span><%out.println(ingredientNotif);%></span></a></li>
                        <li class="nav_packaged"><a href="GetPackagedListServlet" title="Pacakaged Items">Packaged Items <span><%out.println(packagedNotif);%></span></a></li>
      </ul>
    </div>
  </div>
  <!--SIDENAV END-->
  <br class="clear">
  <div class="wrapHeader">
  <!--HEADER START-->
  <header>    
      <hgroup id="logo">
	    <h2>Chopsticks &amp; Spoon</h2>
	  </hgroup>
      <div class="subMenu">
	    <ul>
	      <li><a href="dishes.jsp" title="Manage Dishes">Dishes <span>1</span></a></li>
		  <li><%if(useraccount.getUser_level().equals("user")){
                            %><div style="display: none">
                                <%}else{%><div style="display: inline"><a href="users.jsp" title="Manage Users">Users</a></div><%}%></li>
		  <li><a href="GetIngredientRestockLogListServlet" title="View Logs">View Logs</a></li>
		  <li><a href="index.jsp" title="Log Out">Log Out</a></li>
		  <li id="dateTime">DATE / TIME</li>
	    </ul>
      </div>
    <br class="clear">
  </header>
  <!--HEADER END-->
  </div>
  <!--CONTENT START-->
  <section class="wrapContent">
    <h1>Point of Sales</h1>
    <div class="wrapReceipt">
      <div id="receipt">
        <h3>Receipt</h3>
  	  <table>
	    <tr>
	      <th>Item</th>
	      <th>Price</th>
	      <th>Remove</th>
 	    </tr>
	    <tr>
	      <td>Pancit Bihon</td>
	      <td>230</td>
	      <td class="tableButton"><a href="" title="Remove">- Remove</a></td>
	    </tr>
	    <tr>
	      <td>Teriyaki Beef</td>
	      <td>160</td>
	      <td class="tableButton"><a href="" title="Remove">- Remove</a></td>
	    </tr>
	    <tr>
	      <td>C2 Red 500ml</td>
	      <td>20</td>
	      <td class="tableButton"><a href="" title="Remove">- Remove</a></td>
	    </tr>
	    <tr>
	      <td>C2 Red 500ml</td>
	      <td>20</td>
	      <td class="tableButton"><a href="" title="Remove">- Remove</a></td>
	    </tr>
      </table>
	  <form>
  	    <ul>
	      <li>Total: <span id="receiptTotal">430.00</span></li>
          <li>Payment: <input required type="text" name="payment"></li>
          <li>Change: <span id="receiptTotal">0.00</span></li>
	    </ul>
	    <input type="submit" value="Submit">
      </form>
	  </div>
    </div>
    <br class="clear">
	<form id="searchDish" class="search">
	    <input type="search" name="search" placeholder="Search..">
		<input type="submit" value="Search">
	</form>	  
    <div class="wrapDishMenu">
      <h3>Menu</h3>
      <ul>
        <li><a href="" title="Pancit Bihon">Pancit Bihon <span>230.00</span></a></li>
        <li><a href="" title="Teriyaki Beef">Teriyaki Beef <span>160.00</span></a></li>
        <li><a href="" title="Steamed Dory">Steamed Dory <span>95.00</span></a></li>
        <li><a href="" title="C2 Green 500ml">C2 Green 500ml <span>20.00</span></a></li>
        <li><a href="" title="Mogu Mogu 500ml">Mogu Mogu 500ml <span>25.00</span></a></li>
        <li><a href="" title="C2 Red 1L">C2 Red 1L <span>70.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>
        <li><a href="" title="C2 Red 500ml">C2 Red 500ml <span>20.00</span></a></li>

      </ul>
    </div>
  </section>
  <!--CONTENT END-->
  </div>
</body>
</html>