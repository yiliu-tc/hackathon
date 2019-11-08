import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';
import {environment} from '../../environments/environment';
import { ReviewSearchResultItem } from '../models/review-search-result-item';
import { Review } from '../models/review';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }


  public loadReviews( ):  Observable<any> {
    return this.http.get<Observable<ReviewSearchResultItem[]>>(environment.api + '/v1/reviews', httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  public loadReviewDetail(reviewId: string):  Observable<any> {
    return this.http.get<Observable<ReviewSearchResultItem>>(environment.api
      + '/v1/reviews/' + reviewId,  httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  public saveReview(review: Review):  Observable<any> {
    return this.http.post<Observable<Review>>(environment.api + '/v1/review', review, httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }

}
