import { Component, OnInit, Injectable} from '@angular/core';
import { ReviewService } from '../../services/review-service.service';
import { RatingType } from 'src/app/models/rating-type';
import { Review } from 'src/app/models/review';
import { SelectItem, MessageService} from 'primeng/api';
import { ReviewVo } from 'src/app/models/review-vo';
import {Message} from 'primeng/components/common/api';
import { ConfirmationService } from 'primeng/components/common/confirmationservice';
import { LoginService } from 'src/app/services/login.service';
import { LoginUser } from 'src/app/models/loginuser';

const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUserToken';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css'],
  providers: [ConfirmationService]
})

export class ReviewComponent implements OnInit {

  data: any;
  reviews: ReviewVo[];
  options: any;
  excellentCount: number;
  moderateCount: number;
  poorCount: number;
  review: Review;
  ratingTypes: SelectItem[];
  totalCount: number;
  messages: Message[] = [];
  userLoggedIn: boolean;
  credentials: LoginUser;
  msgs: Message[] = [];
  reviewDetail: ReviewVo;
  showReviewDetails: boolean;

  constructor(private messageService: MessageService,
    private reviewService: ReviewService, private loginService: LoginService,
    private confirmationService: ConfirmationService) {
      this.credentials = new LoginUser();
      this.userLoggedIn = false;
      this.reviews = new Array();
      this.resetData();
      this.ratingTypes = [{label: 'Excellent', value: 1},
                        {label: 'Moderate', value: 2},
                        {label: 'Needs Improvement', value: 3}];
      this.checkUserLoggedIn();
  }

  private resetData() {
    this.excellentCount = 0;
    this.moderateCount = 0;
    this.poorCount = 0;
    this.review = new Review();
    this.reviewDetail = new ReviewVo();
    this.showReviewDetails = false;
  }

  ngOnInit() {
    if (this.userLoggedIn) {
      this.loadReviews();
    }
  }

  login() {
    if (!this.credentials.password || !this.credentials.userName) {
      this.msgs = [];
      this.msgs.push({severity: 'info', summary: 'User Name and Password can not be empty'});
      return;
    }
    this.loginService.login(this.credentials).subscribe((isValid) => {
      if (isValid) {
        this.registerSuccessfulLogin(this.createBasicAuthToken(this.credentials));
        this.loadReviews();
      } else {
        this.msgs = [];
        this.msgs.push({severity: 'info', summary: 'Invalid User Crendential'});
      }
    }, () => {
      this.msgs = [];
        this.msgs.push({severity: 'info', summary: 'Invalid User Crendential'});
    });
  }

  private registerSuccessfulLogin(token: string) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, token);
    this.userLoggedIn = true;
  }

  public logout() {
    sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.userLoggedIn = false;
  }

  private createBasicAuthToken(credentials: LoginUser): string {
    return 'Basic ' + btoa(credentials.userName + ':' + credentials.password);
  }

  public checkUserLoggedIn() {
    const token = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (token === null) {
      this.userLoggedIn = false;
    } else {
      this.userLoggedIn = true;
    }
  }

  private loadReviews() {
    this.reviewService.loadReviews().subscribe(results => {
      this.reviews = new Array();
      results.forEach((element) => {
        const rate_type: RatingType = element.r_type;
        if (rate_type) {
          this.reviews.push({r_type_id: rate_type.rate_type_id,
                             r_type_des: rate_type.rate_type_des,
                             r_comment: element.r_comment,
                             r_date: element.r_date});
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
      this.totalCount = this.reviews.length;
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
       this.resetData();
       this.loadReviews();
     });
  }
  selectReview(review: ReviewVo) {
    this.reviewDetail = review;
    this.showReviewDetails = true;
  }
  closeReviewDetial() {
    this.showReviewDetails = false;
    this.reviewDetail = new ReviewVo();
  }
}
