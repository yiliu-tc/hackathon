import { Component, OnInit, Injectable} from '@angular/core';
import { ReviewSearchResultItem } from '../../models/review-search-result-item';
import { ReviewService } from '../../services/review-service.service';
import { RatingType } from 'src/app/models/rating-type';
import { Review } from 'src/app/models/review';
import { SelectItem} from 'primeng/api';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})

export class ReviewComponent implements OnInit {

  data: any;
  reviews: ReviewSearchResultItem[];
  options: any;
  excellentCount: number;
  moderateCount: number;
  poorCount: number;
  review: Review;
  ratingTypes: SelectItem[];
  constructor(private reviewService: ReviewService) {
     this.resetData();
     this.reviews = new Array();
     this.review = new Review();
     this.ratingTypes = [{label: 'Excellent', value: 1},
                        {label: 'Moderate', value: 2},
                        {label: 'Needs Improvement', value: 3}];
  }

  private resetData() {
    this.excellentCount = 0;
    this.moderateCount = 0;
    this.poorCount = 0;
  }

  ngOnInit() {
    this.loadReviews();
  }

  private loadReviews() {
    this.reviewService.loadReviews().subscribe(results => {
      this.reviews = results;
      results.forEach((element) => {
        const rate_type: RatingType = element.r_type;
        if (rate_type) {
          switch (rate_type.rate_type_id) {
            case 1:
              this.excellentCount++;
              break;
            case 2:
              this.moderateCount++;
              break;
            case 3:
              this.poorCount++;
              break;
          }
        }
      });
      this.data = {
        labels: ['Excellent', 'Moderate', 'Needs Improvement'],
        datasets: [
          {
            data: [this.excellentCount, this.moderateCount, this.poorCount],
            backgroundColor: [
              "#03fc62",
              "#fcdb03",
              "#fc033d"
            ],
            hoverBackgroundColor: [
              "#03fc62",
              "#fcdb03",
              "#fc033d"
            ]
          }
        ]
      };
      this.options = {
        title: {
          display: true,
          text: 'Service Satisfaction Survey',
          fontSize: 16
        },
        legend: {
          position: 'bottom'
        }
      };
    });
  }

   submitNewReview(review: Review) {
     this.reviewService.saveReview(review).subscribe(results => {
       this.review = new Review();
       this.resetData();
       this.loadReviews();
     });
  }

  selectData($event) {
    
  }
}
