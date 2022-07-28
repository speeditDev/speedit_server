package speedit.bookplate.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.follow.dto.FollowedDto;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.user.entity.User;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowService {

    private final FollowRepository followRepository;

    private final UserRepository userRepository;

    @Transactional
    public void createFollow(long followerId,long followedId){
        User follower=userRepository.findByUserIdx(followerId);
        User followed=userRepository.findByUserIdx(followedId);

        Follow follow = Follow.createFollow(follower,followed);
        followRepository.save(follow);
    }

    @Transactional
    public void deleteFollow(long followerId,long followedId){
        User follower=userRepository.findByUserIdx(followerId);
        User followed=userRepository.findByUserIdx(followedId);

        Follow follow = Follow.createFollow(follower,followed);
        followRepository.delete(follow);
    }

    public List<FollowedDto> getFollowing(long followerIdx){
        User memberUser = userRepository.findByUserIdx(followerIdx);
        List<FollowedDto> array = new ArrayList<>();
        for(Follow follow:followRepository.findByFollower(memberUser)){
            FollowedDto dto = new FollowedDto();
            dto.setProfileImg(follow.getFollowed().getProfileImg());
            dto.setNickname(follow.getFollowed().getNickname());
            dto.setJob(follow.getFollowed().getJob());
            dto.setCompany(follow.getFollowed().getCompany());
            array.add(dto);
        }
        return array;
    }

    public List<FollowedDto> getFollowed(long followerIdx) {
        User memberUser = userRepository.findByUserIdx(followerIdx);
        List<FollowedDto> array = new ArrayList<>();
        for (Follow follow : followRepository.findByFollowed(memberUser)) {
            FollowedDto dto = new FollowedDto();
            dto.setProfileImg(follow.getFollower().getProfileImg());
            dto.setNickname(follow.getFollower().getNickname());
            dto.setJob(follow.getFollower().getJob());
            dto.setCompany(follow.getFollower().getCompany());
            array.add(dto);
        }
        return array;
    }

}
