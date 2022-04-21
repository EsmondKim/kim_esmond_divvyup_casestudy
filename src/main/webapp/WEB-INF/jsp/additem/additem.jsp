<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Add Item</title>

<body id="add-item-body">

<div class="container">

    <h1>Add Menu Item</h1>

    <div class="col-row-12">
        <form class="wrapper" action="/menu/additem/submit" method="post">
            <div class="row"><!--registration fields row-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="item" id="itemId" placeholder="Item to Add" value=${form.item}>
                    <label for="itemId">Item to Add</label>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="description" id="descriptionId" placeholder="Description" value=${form.description}>
                    <label for="descriptionId">Description</label>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <input type="number" class="form-control" name="price" id="priceId" placeholder="Price" value=${form.price}>
                    <label for="priceId">Price</label>
                </div> <!--form-floating mb-3-->
                <button type="submit">Submit</button>
            </div><!--diners fields row-->
        </form>
    </div> <!--col-row-12-->

<jsp:include page="../include/footer.jsp"/>

