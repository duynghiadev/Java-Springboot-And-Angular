package com.project.shopapp.services.comment;

import com.project.shopapp.dtos.CommentDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.*;
import com.project.shopapp.models.Comment;
import com.project.shopapp.repositories.CommentRepository;
import com.project.shopapp.repositories.ProductRepository;
import com.project.shopapp.repositories.UserRepository;
import com.project.shopapp.responses.comment.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService implements ICommentService{
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    @Override
    @Transactional
    public Comment insertComment(CommentDTO commentDTO) {
        User user = userRepository.findById(commentDTO.getUserId()).orElse(null);
        Product product = productRepository.findById(commentDTO.getProductId()).orElse(null);
        if (user == null || product == null) {
            throw new IllegalArgumentException("User or product not found");
        }
        Comment newComment = Comment.builder()
                .user(user)
                .product(product)
                .content(commentDTO.getContent())
                .build();
        return commentRepository.save(newComment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional
    public void updateComment(Long id, CommentDTO commentDTO) throws DataNotFoundException {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Comment not found"));
        existingComment.setContent(commentDTO.getContent());
        commentRepository.save(existingComment);
    }

    @Override
    public List<CommentResponse> getCommentsByUserAndProduct(Long userId, Long productId) {
        List<Comment> comments = commentRepository.findByUserIdAndProductId(userId, productId);
        return comments.stream()
                .map(comment -> CommentResponse.fromComment(comment))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getCommentsByProduct(Long productId) {
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(comment -> CommentResponse.fromComment(comment))
                .collect(Collectors.toList());
    }

}
