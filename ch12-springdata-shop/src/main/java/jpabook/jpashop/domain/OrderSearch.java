package jpabook.jpashop.domain;

import org.springframework.data.jpa.domain.Specifications;

import static jpabook.jpashop.domain.OrderSpec.searchLike;
import static jpabook.jpashop.domain.OrderSpec.memberNameLike;
import static jpabook.jpashop.domain.OrderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * Created by holyeye on 2014. 3. 15..
 */
public class OrderSearch {

    private String searchField;      //검색필드
    private String searchValue;      //검색값
    private String memberName;      //회원 이름
    private OrderStatus orderStatus;//주문 상태

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Specifications<Order> withMemberName() {
        return where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }

    public Specifications<Order> withSearchField() {
        return where(searchLike(searchField, searchValue))
                .and(orderStatusEq(orderStatus));
    }

}
