<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../views/includes/header.jsp"%>


<!-- Product section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="row gx-4 gx-lg-5 align-items-center">
			<div class="col-md-6">
				<img class="card-img-top mb-5 mb-md-0" src="${book.thumbnail }"
					alt="..." onError="this.src='/resources/img/no_thumnail.png'" />
			</div>
			<div class="col-md-6">
				<div class="small mb-1">ISBN: ${book.isbn}</div>
				<h1 class="display-5 fw-bolder">${book.title }</h1>
				<div>글쓴이: ${book.author}</div>
				<c:if test="${!empty book.publisher}">
					<div>출판사: ${book.publisher }</div>
				</c:if>
				<c:if test="${!empty book.translator}">
					<div>번역가: ${book.translator }</div>
				</c:if>
				<div class="fs-5 mb-3">
					<span class="text-decoration-line-through">${book.price }원</span> <span>${book.salePrice }원</span>
				</div>
				<p class="lead">${book.contents }</p>
				<div class="d-flex">

					<a href="${book.url }" class="btn btn-info " role="button">Link</a>
					<button class="btn btn-outline-dark flex-shrink-0 mx-3" type="button">
						<i class="bi-cart-fill me-1"></i> Add to cart
					</button>
				</div>
			</div>
		</div>
	</div>
</section>





<!-- Related items section-->
<section class="py-5 bg-light">
	<div class="container px-4 px-lg-5 mt-5">
		<h2 class="fw-bolder mb-4">Related products</h2>
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Fancy Product</h5>
							<!-- Product price-->
							$40.00 - $80.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">View options</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Sale badge-->
					<div class="badge bg-dark text-white position-absolute"
						style="top: 0.5rem; right: 0.5rem">Sale</div>
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Special Item</h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
							</div>
							<!-- Product price-->
							<span class="text-muted text-decoration-line-through">$20.00</span>
							$18.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Sale badge-->
					<div class="badge bg-dark text-white position-absolute"
						style="top: 0.5rem; right: 0.5rem">Sale</div>
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Sale Item</h5>
							<!-- Product price-->
							<span class="text-muted text-decoration-line-through">$50.00</span>
							$25.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Popular Item</h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
							</div>
							<!-- Product price-->
							$40.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<%@include file="../views/includes/footer.jsp"%>
