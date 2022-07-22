package speedit.bookplate.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.follow.entity.Follow;
import speedit.bookplate.user.UserRepository;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.utils.JwtService;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowService {

    private final FollowRepository followRepository;

    private final UserRepository userRepository;

    private final JwtService jwtService;

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




}
