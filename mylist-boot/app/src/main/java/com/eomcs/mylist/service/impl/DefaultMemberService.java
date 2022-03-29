package com.eomcs.mylist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eomcs.mylist.dao.MemberDao;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.MemberService;

@Service // Spring IoC 컨테이너가 객체를 만들어 저장할 때 클래스 이름을 사용한다. 예) defaultBoardService
public class DefaultMemberService implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Override
  @Transactional
  public int add(Member member) {
    return memberDao.insert(member);
  }

}







