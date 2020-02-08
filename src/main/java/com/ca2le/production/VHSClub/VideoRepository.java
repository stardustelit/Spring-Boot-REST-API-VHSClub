package com.ca2le.production.VHSClub;

import org.springframework.data.jpa.repository.JpaRepository;

interface VideoRepository extends JpaRepository<VideoCassette, Long> {

}