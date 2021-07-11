/**
 * 
 */

let page = 1;

function booksLoad() {
	//ajax로 Page<Image> 가져올 예정(3개)

	console.log(page);

	$.ajax({
		type: "get",
		url: `/book/list2?page=${page}`,
		dateType: "json"

	}).done(res => {
		//console.log("feedLoad됨");
		//console.log(res.data.content);

		let books = res;
		console.log(books);
		books.forEach((book) => {
			
			//console.log("book", book);
			let bookBox = bookItem(book);
			//이미 정렬을 한 상태로 들고오므로 append
			$("#book-item").append(bookBox);
		});      //리턴받을거면 map 써야됨

	});



}

booksLoad(); //최초 페이지 로딩 때 필요하므로,

//새로고침 리스너와 유사하게
window.onbeforeunload = function (e) {
	
/*	var e = e || window.event;

    // For IE and Firefox
    if (e) {
        e.returnValue = 'Leaving the page';
    }

    // For Safari
    return 'Leaving the page';*/
	
	
	$("#book-item").empty();
	page = 1;

};


$(window).scroll(() => {
	/*console.log("scrollTop",$(window).scrollTop());
	console.log("document height",$(document).height());
	console.log("window height",$(window).height());*/

	let checkNum = $(window).scrollTop() - ($(document).height() - $(window).height());

	//console.log("checkNum: ",checkNum);

	//근사치 계산
	if (checkNum < 1 && checkNum > -1) {
		page++;
		//console.log(page);
		booksLoad();
	}

});


function bookItem(book) {
	
	//console.log("들어옴");
	
	let result = `
<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="${book.thumbnail}" alt="..." onError="this.src='/resources/img/no_thumnail.png';"/>
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${book.title}</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div>${book.author}</div>
								</div>
								<!-- Product price-->
								${book.price} 원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="/book/item/${book.id}">상세보기</a>
							</div>
						</div>
					</div>
				</div>`;
				
	return result;
}